# clean-arch-android

Sample for simple clean architecture in Android using Presenter, Bussiness and Data layers.

:+1:

## Project Structuture

The project proposes a clean architecture based on Presentation Layer, Bussiness Layer and Data Layer
+ **Presentation Layer**. Takes cares of the View, activities, layouts and calls to bussiness interactors
  - presenters
    - interfaces with callbacks for the view
    - implementation for presenters
  - ui: The *view*: just controls the layout, and interacts with the presenter
    - activities
    - adapters  
+ **Bussiness Layer**. provides  methods that presentation layer can use, and interfaces that data layer must implement.
  - models: data models for holding bussiness information
  - interactors: get calls from presenters, and call data layer
  - repositories: interfaces for establishing a contract to follow by data implementations
+ **Data Layer**
  - api
  - repositories implementation
  
## Android Libraries

In this project a typicall set of Android libreries is used for saving boilerplate and extra work.

+ [**Dagger**](https://github.com/google/dagger): A fast dependency injector for Android and Java.
+ [**Retrofit**](https://github.com/square/retrofit): Type-safe HTTP client for Android and Java
+ [**GSON**](https://github.com/google/gson): Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object.
+ [**Butterknife**](https://github.com/JakeWharton/butterknife): Field and method binding for Android views which uses annotation processing to generate boilerplate code for you.
+ [**RxJava**](https://github.com/ReactiveX/RxJava): RxJava is a Java VM implementation of Reactive Extensions: a library for composing asynchronous and event-based programs by using observable sequences.
