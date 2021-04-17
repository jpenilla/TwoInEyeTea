import xyz.jpenilla.toothpick.gitCmd
import xyz.jpenilla.toothpick.toothpick

plugins {
    `java-library`
    id("xyz.jpenilla.toothpick") version "1.0.0-SNAPSHOT"
}

toothpick {
    forkName = "TwoInEyeTea"
    groupId = "xyz.jpenilla"
    val versionTag = '"' + (gitCmd("rev-parse", "--short", "HEAD").output ?: "UNKNOWN") + '"'
    forkVersion = "git-$forkName-$versionTag"
    forkUrl = "https://github.com/jpenilla/TwoInEyeTea"

    minecraftVersion = "1.16.5"
    nmsPackage = "1_16_R3"
    nmsRevision = "R0.1-SNAPSHOT"

    upstream = "Tuinity"
    upstreamBranch = "origin/master"

    server {
        project = project(":$forkNameLowercase-server")
        patchesDir = file("patches/server")
    }
    api {
        project = project(":$forkNameLowercase-api")
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
