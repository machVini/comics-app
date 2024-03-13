# Marvel Comics Listing App

This is an app built to list comics from Marvel using the official Marvel API. The main goal of this project is to consolidate knowledge about mobile app development and to learn about the migration/transition of software architectures, specifically from the VPI (View-Presenter-Interactor) architecture to MVVM (Model-View-ViewModel).

## Key Features

- Listing Marvel comics.
- Comic details including title, description, images, etc.
- Integration with the official Marvel API to fetch comic data.

## Architecture

The initial project was developed using the VPI (View-Presenter-Interactor) architecture, a common approach for Android mobile app development. However, as part of the learning objective, we are gradually migrating to the MVVM (Model-View-ViewModel) architecture, which offers a clearer separation of concerns and facilitates code testability and maintenance.

## Technologies Used

- Kotlin: Primary programming language.
- Android SDK: Framework for Android app development.
- Retrofit: Library for HTTP requests in Android.
- LiveData: Android Jetpack component for updating the user interface.
- ViewModel: Part of Android Jetpack that helps manage and preserve UI-related data.
