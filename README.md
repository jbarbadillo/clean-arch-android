# clean-arch-android
Sample for simple clean architecture in Android using Presenter, Bussiness and Data layers.

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
  - repositories: interfaces for stablishing a contrat to follow by data implementations
+ Data Layer
  - api
  - repositories implementation
