class Resource

fun resource(name: String) = Resource::class.java.getResourceAsStream(name)