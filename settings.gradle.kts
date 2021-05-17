import xyz.jpenilla.toothpick.setupToothpickProject
import java.util.Locale

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("Toothpick")
}

plugins {
    id("xyz.jpenilla.toothpick.settings")
}

val forkName = "TwoInEyeTea"
rootProject.name = forkName.toLowerCase(Locale.ROOT)
setupToothpickProject(rootProject, forkName)
