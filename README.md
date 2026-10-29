# MojoLauncher (MJLauncher) 🚀

> Launcher de **Minecraft: Java Edition para Android**, basado en **PojavLauncher**. Optimizado para dispositivos de gama baja (2GB RAM o menos).

<p align="center">
  <img src="./app_pojavlauncher/src/main/assets/pojavlauncher.png" width="120" height="120" alt="MojoLauncher">
</p>

<p align="center">
  <a href="https://github.com/Adriyache32/MojoLauncher/actions"><img src="https://github.com/Adriyache32/MojoLauncher/workflows/Android%20CI/badge.svg" alt="Android CI"></a>
  <img src="https://img.shields.io/github/commit-activity/m/Adriyache32/MojoLauncher?style=flat-square" alt="Commit Activity">
  <img src="https://img.shields.io/github/last-commit/Adriyache32/MojoLauncher?style=flat-square" alt="Last Commit">
  <img src="https://img.shields.io/github/repo-size/Adriyache32/MojoLauncher?style=flat-square" alt="Repo Size">
  <img src="https://img.shields.io/github/issues/Adriyache32/MojoLauncher?style=flat-square" alt="Issues">
  <img src="https://img.shields.io/github/license/Adriyache32/MojoLauncher?style=flat-square" alt="License">
  <img src="https://img.shields.io/github/stars/Adriyache32/MojoLauncher?style=flat-square&color=gold" alt="Stars">
  <img src="https://img.shields.io/github/downloads/Adriyache32/MojoLauncher/total?style=flat-square" alt="Downloads">
</p>

## ✨ Características

- **Basado en PojavLauncher** — Fork optimizado y mantenido
- **2GB RAM mínimo** — Funciona en dispositivos de gama baja
- **Java 8/11/17/21** — Soporte multi-version
- **Forge / Fabric / Quilt / NeoForge** — Modloaders integrados
- **Cuenta Microsoft / Offline** — Autenticación completa
- **Optimizaciones de rendimiento** — JVM args personalizados, compresión de assets
- **Interfaz Material Design 3** — Tema oscuro/claro, responsive
- **Descarga paralela** — Librerías y assets simultáneos

## 📱 Descargas

| Versión | Arquitectura | Enlace |
|---------|--------------|--------|
| Latest Release | arm64-v8a | [GitHub Releases](https://github.com/Adriyache32/MojoLauncher/releases) |
| Latest Release | armeabi-v7a | [GitHub Releases](https://github.com/Adriyache32/MojoLauncher/releases) |
| Nightly | arm64-v8a | [Actions Artifacts](https://github.com/Adriyache32/MojoLauncher/actions) |

## 🛠️ Compilar desde fuente

```bash
# Requisitos: JDK 17+, Android SDK, Gradle 8+
git clone https://github.com/Adriyache32/MojoLauncher.git
cd MojoLauncher

# Debug APK
./gradlew assembleDebug

# Release APK (requiere keystore)
./gradlew assembleRelease

# Bundle para Play Store
./gradlew bundleRelease
```

## ⚙️ Configuración Gradle

```gradle
// gradle.properties
org.gradle.jvmargs=-Xmx4g -XX:MaxMetaspaceSize=512m
android.enableR8=true
android.enableR8.fullMode=true
mojolauncher.optimizeForLowRam=true
mojolauncher.targetApi=34
```

## 🏗️ Arquitectura

```
MojoLauncher/
├── app_pojavlauncher/       # App principal (fork PojavLauncher)
│   ├── src/main/
│   │   ├── java/com/mojang/pojavlauncher/
│   │   │   ├── MainActivity.java
│   │   │   ├── LaunchService.java
│   │   │   ├── AuthManager.java
│   │   │   └── ...
│   │   ├── assets/          # Iconos, splash, config por defecto
│   │   └── res/             # Layouts, drawables, values
├── forge_installer/         # Instalador Forge integrado
├── glfw/                    # GLFW bindings para Android
├── scripts/                 # Scripts de build/ci
└── .github/workflows/       # Android CI + Release
```

## 🤝 Contribuir

Ver [CONTRIBUTING.md](CONTRIBUTING.md)

## 📄 Licencia

LGPL-3.0 (heredada de PojavLauncher) — ver [LICENSE](LICENSE)

## 🙏 Créditos

- **PojavLauncher Team** — Base original
- **Mojang** — Minecraft: Java Edition
- **Forge/Fabric/Quilt/NeoForge Teams** — Modloaders

---

**¿Te funciona en tu dispositivo de gama baja? ¡Cuéntanos en Issues! ⭐**
