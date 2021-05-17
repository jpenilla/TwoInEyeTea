plugins {
    `java-library`
    id("xyz.jpenilla.toothpick")
}

toothpick {
    forkName = "TwoInEyeTea"
    groupId = "xyz.jpenilla"
    val versionTag = "\"${commitHash() ?: error("Could not obtain git hash")}\""
    forkVersion = "git-$forkName-$versionTag"
    forkUrl = "https://github.com/jpenilla/TwoInEyeTea"

    minecraftVersion = "1.16.5"
    nmsPackage = "1_16_R3"
    nmsRevision = "R0.1-SNAPSHOT"

    upstream = "Tuinity"
    upstreamBranch = "origin/master"

    server {
        project = projects.twoineyeteaServer.dependencyProject
        patchesDir = file("patches/server")
    }
    api {
        project = projects.twoineyeteaApi.dependencyProject
        patchesDir = file("patches/api")
    }
}

subprojects {
    repositories {
        maven("https://nexus.velocitypowered.com/repository/velocity-artifacts-snapshots/")
    }

    java {
        sourceCompatibility = JavaVersion.toVersion(8)
        targetCompatibility = JavaVersion.toVersion(8)
    }
}
