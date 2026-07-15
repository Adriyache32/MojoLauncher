package net.kdt.pojavlaunch.modloaders.modpacks;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.kdt.pojavlaunch.Tools;
import net.kdt.pojavlaunch.modloaders.modpacks.api.ModLoader;
import net.kdt.pojavlaunch.modloaders.modpacks.api.ModrinthApi;
import net.kdt.pojavlaunch.modloaders.modpacks.models.Constants;
import net.kdt.pojavlaunch.modloaders.modpacks.models.ModDetail;
import net.kdt.pojavlaunch.modloaders.modpacks.models.ModItem;
import net.kdt.pojavlaunch.utils.DownloadUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Registry of modpacks that ship baked into MojoLauncher as the recommended
 * default for specific game versions. When a user installs/plays one of these
 * versions, MojoLauncher can pull the matching modpack straight from Modrinth
 * without the user having to search for it.
 */
public final class BuiltInModpacks {
    private BuiltInModpacks() {}

    public static final class BuiltInModpack {
        public final String gameVersion;
        public final String projectId;
        public final String name;
        public final String loader;
        public final String description;
        public final String iconUrl;

        public BuiltInModpack(String gameVersion, String projectId, String name,
                              String loader, String description, String iconUrl) {
            this.gameVersion = gameVersion;
            this.projectId = projectId;
            this.name = name;
            this.loader = loader;
            this.description = description;
            this.iconUrl = iconUrl;
        }
    }

    private static final Map<String, BuiltInModpack> REGISTRY = new HashMap<>();
    static {
        // 1.20.1 -> Keo Optimized (Fabric, low-end friendly)
        REGISTRY.put("1.20.1", new BuiltInModpack(
                "1.20.1",
                "oePruTVg",
                "Keo Optimized",
                "Fabric",
                "Modpack optimizado de bajo consumo para 1.20.1. Pensado para correr fluido en dispositivos gama baja.",
                "https://cdn.modrinth.com/data/oePruTVg/icon.png"
        ));
        // 26.1.2 -> Simply Optimized Reloaded (NeoForge, ligero y actual)
        REGISTRY.put("26.1.2", new BuiltInModpack(
                "26.1.2",
                "Aa5L6RtV",
                "Simply Optimized Reloaded",
                "NeoForge",
                "Modpack ligero y optimizado para 26.1.2. Mantiene la vanilla pero con mejor rendimiento.",
                "https://cdn.modrinth.com/data/Aa5L6RtV/icon.png"
        ));
    }

    public static BuiltInModpack getForVersion(String gameVersion) {
        if (gameVersion == null) return null;
        return REGISTRY.get(gameVersion);
    }

    public static boolean hasBuiltInModpack(String gameVersion) {
        return getForVersion(gameVersion) != null;
    }

    /**
     * Resolve the Modrinth version + mrpack download URL for the given built-in modpack.
     * @return a ModDetail ready to be installed, or null if not found
     */
    public static ModDetail resolveModDetail(BuiltInModpack modpack) throws IOException {
        if (modpack == null) return null;
        String url = "https://api.modrinth.com/v2/project/" + modpack.projectId
                + "/version?game_versions=[\"" + modpack.gameVersion + "\"]";
        String json = DownloadUtils.downloadString(url);
        JsonArray versions = Tools.GLOBAL_GSON.fromJson(json, JsonArray.class);
        if (versions == null || versions.size() == 0) return null;

        // Pick the first/latest version that targets the requested game version
        JsonObject version = versions.get(0).getAsJsonObject();
        String versionName = version.has("name") ? version.get("name").getAsString() : modpack.gameVersion;
        JsonArray files = version.getAsJsonArray("files");
        if (files == null) return null;

        String fileUrl = null;
        String fileHash = null;
        for (JsonElement f : files) {
            JsonObject fo = f.getAsJsonObject();
            String filename = fo.has("filename") ? fo.get("filename").getAsString() : "";
            boolean primary = fo.has("primary") && fo.get("primary").getAsBoolean();
            if (filename.endsWith(".mrpack") && primary) {
                fileUrl = fo.get("url").getAsString();
                JsonObject hashes = fo.has("hashes") ? fo.getAsJsonObject("hashes") : null;
                if (hashes != null && hashes.has("sha1")) fileHash = hashes.get("sha1").getAsString();
                break;
            }
        }
        if (fileUrl == null) return null;

        ModItem item = new ModItem(Constants.SOURCE_MODRINTH, true, modpack.projectId,
                modpack.name, modpack.description, modpack.iconUrl);
        return new ModDetail(item,
                new String[]{versionName},
                new String[]{modpack.gameVersion},
                new String[]{fileUrl},
                new String[]{fileHash});
    }

    /**
     * Download and install the built-in modpack, creating a ready-to-play instance.
     * @return the mod loader info of the installed modpack, or null if it could not be resolved
     */
    public static ModLoader install(BuiltInModpack modpack) throws IOException {
        ModDetail detail = resolveModDetail(modpack);
        if (detail == null) return null;
        ModrinthApi api = new ModrinthApi();
        return api.installModpack(detail, 0);
    }

    public static ModLoader installForVersion(String gameVersion) throws IOException {
        return install(getForVersion(gameVersion));
    }
}
