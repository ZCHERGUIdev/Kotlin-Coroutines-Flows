# Kotlin-Coroutines-Flows


#### Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously. The emitted values must be of the same type. For example, a Flow<Int> is a flow that emits integer values.
#### A flow is very similar to an Iterator that produces a sequence of values, but it uses suspend functions to produce and consume values asynchronously. This means, for example, that the flow can safely make a network request to produce the next value without blocking the main thread.

##### A producer produces data that is added to the stream. Thanks to coroutines, flows can also produce data asynchronously.</br>
##### Intermediaries(Optional)  can modify each value emitted into the stream or the stream itself.</br>
##### A consumer(collecter) consumes the values from the stream.</br></br></br></br>


## To use coroutines in your Android project, add the following dependency to your app's build.gradle file:</br>
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
}
