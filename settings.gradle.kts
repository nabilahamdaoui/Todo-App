rootProject.name = "todo-app"

include("server")
include("client")

rootProject.children.forEach { subproject ->
    subproject.buildFileName = "${subproject.name}.gradle.kts"
}

