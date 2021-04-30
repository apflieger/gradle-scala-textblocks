plugins {
    scala
}
repositories {
    mavenCentral()
}
dependencies {
    implementation("org.scala-lang:scala-library:2.13.5")
}
sourceSets {
    main {
        // Put everything in the scala source set to use joint compilation
        withConvention(ScalaSourceSet::class) {
            scala {
                srcDir("src/main/java")
            }
        }
        java {
            setSrcDirs(emptyList<Any>())
        }
    }
}

// On java 15, we need to activate preview features to allow the use of record in MyClass.
tasks.withType<ScalaCompile> {
    options.compilerArgs.addAll(listOf("--enable-preview"))
    scalaCompileOptions.forkOptions.apply {
        jvmArgs = listOf("--enable-preview") // I don't know why there's a jvm that loads all classes but this is required
    }
}