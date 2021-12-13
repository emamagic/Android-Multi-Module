@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}

rootProject.name = "Limonad_Android"
include(
        ":app",
        ":signin",
        ":signup",
        ":intro",
        ":workspace:workspace-create",
        ":workspace:workspace-select",
        ":workspace:workspace-add-member",
)
