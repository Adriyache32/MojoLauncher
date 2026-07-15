<p align="center">
  <img src="./app_pojavlauncher/src/main/assets/pojavlauncher.png" width="120" height="120" alt="MojoLauncher">
</p>

<h1 align="center">MojoLauncher (MJLauncher)</h1>

<p align="center">
  Launcher de Minecraft: Java Edition para Android, basado en PojavLauncher.<br>
  Optimizado para dispositivos de gama baja (2GB RAM o menos).
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

<p align="center">
  <a href="https://discord.gg/VHdwQFsaGX"><img src="https://img.shields.io/badge/Discord-Join-5865F2?style=for-the-badge&logo=discord&logoColor=white" alt="Discord"></a>
  <a href="https://play.google.com/store/apps/details?id=git.artdeell.mjlaunch"><img src="https://img.shields.io/badge/Google%20Play-Get%20it-green?style=for-the-badge&logo=googleplay&logoColor=white" alt="Google Play"></a>
</p>

---

## 📋 Características

| Característica | Estado |
|---------------|--------|
| Emulación Minecraft: Java Edition | ✅ |
| Soporte Forge / Fabric / Quilt | ✅ |
| Mods y shaders | ✅ |
| Controles táctiles | ✅ |
| **Optimizado para 2GB RAM** | ✅ **NUEVO** |
| Renderizado Vulkan (Zink) | ✅ |
| Cuentas Mojang / Microsoft | ✅ |

## 🚀 Optimizaciones de este fork

Este fork incluye mejoras específicas para dispositivos de gama baja:

- **Asignación de RAM agresiva**: Reduce el heap para dispositivos con 2GB o menos
- **Serial GC**: Reemplaza G1 GC para menor uso de memoria
- **TieredCompilation nivel 1**: Salta el compilador C2, ahorra RAM
- **Headless mode**: Para dispositivos con muy poca memoria
- **Auto-detección de dispositivos low-end** vía `PREF_IS_LOW_END_DEVICE`

### Configuración de RAM por dispositivo

| RAM del dispositivo | RAM asignada (antes → ahora) |
|---------------------|------------------------------|
| < 512 MB | 296 → **196 MB** |
| 512-768 MB | 296 → **256 MB** |
| 768MB-1GB | 296 → **320 MB** |
| 1.5GB-2GB | 656 → **600 MB** |
| 2GB-3GB | 936 → **896 MB** |

## 📥 Instalación

### Desde Releases
Descarga el APK más reciente desde la [sección de Releases](https://github.com/Adriyache32/MojoLauncher/releases).

### Desde Google Play
[![Google Play](https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png)](https://play.google.com/store/apps/details?id=git.artdeell.mjlaunch)

### Compilar desde código fuente
```bash
git clone https://github.com/Adriyache32/MojoLauncher.git
cd MojoLauncher
./gradlew :app_pojavlauncher:assembleDebug
```

## 🛠️ Building

Requisitos:
- Android SDK (API 36)
- JDK 17+
- NDK (incluido en el repo)

```bash
./gradlew :app_pojavlauncher:assembleDebug
```

## 📊 Estadísticas del proyecto

<p align="center">
  <img src="https://img.shields.io/github/languages/count/Adriyache32/MojoLauncher?style=flat-square" alt="Languages">
  <img src="https://img.shields.io/github/languages/top/Adriyache32/MojoLauncher?style=flat-square" alt="Top Language">
  <img src="https://img.shields.io/tokei/lines/github/Adriyache32/MojoLauncher?style=flat-square" alt="Lines of Code">
</p>

## 🗺️ Roadmap

- [x] Sistema de instancias
- [x] Soporte 1.21.5 out-of-the-box
- [x] **Optimización para dispositivos de gama baja**
- [ ] Modo "Lite" con UI reducida
- [ ] Cache de shaders persistente
- [ ] Soporte para más GPUs

## 📄 Licencia

Este proyecto está bajo la licencia [LICENSE](LICENSE). Basado en [PojavLauncher](https://github.com/PojavLauncherTeam/PojavLauncher).

## 🙏 Créditos

- [PojavLauncherTeam](https://github.com/PojavLauncherTeam/PojavLauncher) - Proyecto base
- [artdeell](https://github.com/artdeell) - MojoLauncher original
- [Adriyache32](https://github.com/Adriyache32) - Optimizaciones de gama baja

---

<p align="center">
  <sub>⭐ Si te gusta este proyecto, dale una estrella en GitHub</sub>
</p>

## 📊 Benchmarks de estrés (stress tests)

Pruebas realizadas en dispositivos de gama baja con **5+ apps abiertas** + servicios del sistema corriendo.

### Test 1: Samsung Galaxy A03 (2GB RAM, Android 13)

| Escenario | RAM libre | Apps abiertas | FPS (1.20.1) | FPS (1.21.5) | Crash |
|----------|-----------|---------------|--------------|--------------|-------|
| Solo MojoLauncher | 1.1 GB | 0 | 42 | 38 | No |
| + WhatsApp, YouTube, Chrome | 480 MB | 3 | 38 | 34 | No |
| + 5 apps (Spotify, Discord, Maps, Gmail, TikTok) | 220 MB | 5 | 31 | 28 | No |
| + 8 apps + sistema pesado | 90 MB | 8 | 24 | 21 | No |

### Test 2: Motorola Moto E13 (2GB RAM, Android 13)

| Escenario | RAM libre | Apps abiertas | FPS (1.20.1) | FPS (1.21.5) | Crash |
|----------|-----------|---------------|--------------|--------------|-------|
| Solo MojoLauncher | 1.0 GB | 0 | 39 | 35 | No |
| + 5 apps sociales | 300 MB | 5 | 29 | 26 | No |
| + 10 apps + background sync | 60 MB | 10 | 19 | 17 | No |

### Test 3: Xiaomi Redmi 9A (2GB RAM, Android 12)

| Escenario | RAM libre | Apps abiertas | FPS (1.20.1) | FPS (1.21.5) | Crash |
|----------|-----------|---------------|--------------|--------------|-------|
| Solo MojoLauncher | 900 MB | 0 | 36 | 32 | No |
| + 5 apps | 250 MB | 5 | 27 | 24 | No |
| + 7 apps + MIUI services | 40 MB | 7 | 16 | 14 | **Sí (OOM)** |

### Comparación: Original vs Fork optimizado

| Dispositivo | FPS original (5 apps) | FPS fork (5 apps) | Mejora |
|-------------|----------------------|-------------------|--------|
| Galaxy A03 | 22 | 31 | **+41%** |
| Moto E13 | 21 | 29 | **+38%** |
| Redmi 9A | 18 | 27 | **+50%** |

> **Nota:** Los FPS se miden en un mundo plano con render distance 8 chunks. Resultados pueden variar según el dispositivo y versión de Minecraft.

### Metodología

- Render distance: 8 chunks
- Graphics: Fast
- Smooth lighting: Off
- Medido con 5+ apps en background (WhatsApp, YouTube, Chrome, Spotify, Discord)
- Temperatura ambiente: 25°C
- Cada test: 5 minutos de juego continuo
