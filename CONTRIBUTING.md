# Contribuir a MojoLauncher

¡Gracias por tu interés en contribuir!

## Cómo contribuir

1. Haz fork del repositorio
2. Crea una rama para tu feature (`git checkout -b feature/nueva-optimizacion`)
3. Haz commit de tus cambios (`git commit -m 'Añade optimización X'`)
4. Push a tu fork (`git push origin feature/nueva-optimizacion`)
5. Abre un Pull Request

## Guías de código

- Sigue el estilo de código existente (Java para la app, Kotlin donde aplique)
- Documenta los cambios en el README si afectan al usuario
- Asegúrate de que el build pase en CI antes de abrir PR
- Para optimizaciones de rendimiento, incluye benchmarks o justificación

## Reportar bugs

Abre un issue con:
- Modelo del dispositivo
- RAM total
- Versión de Android
- Logcat del error

## Build local

```bash
./gradlew :app_pojavlauncher:assembleDebug
```
