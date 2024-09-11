pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Livrando"
include(":app")
include(":core:database")
include(":feature:journal")
include(":core:model")
include(":core:data")
include(":core:ui")
include(":core:data-test")
include(":core:common")
