# Audio Catalog Organizer

**Audio Catalog Organizer** is a robust Java console application designed for efficient management of a personal multimedia library. This project demonstrates a strong understanding of **Object-Oriented Programming**, **SOLID principles**, and the **MVC** architectural pattern.

This application allows users to organize Songs, Podcasts, Audiobooks, Music Albums, and Playlists, ensuring data persistence through file storage.

## Key Features

* **Multi-Format Support:** Create and manage various audio types: Songs, Podcasts, Audiobooks, Music Albums, and Playlists.
* **Data Persistence:** Automatic saving and loading of the entire catalog from the file system, ensuring no data is lost between sessions (Silent Auto-save).
* **Smart Search:** Advanced filtering capabilities allowing users to search by Title, Author, and Genre simultaneously.
* **Data Integrity:** Centralized Input Validation that prevents invalid data entry (e.g., future release years, negative duration).
* **Dynamic Playlists:** Logic for creating nested playlists and grouping different media types.
* **Enhanced UX:** Duration is displayed in formatted `HH:MM:SS` style, and menus support smart navigation (instant exit).

## Architecture & Design

The project is built upon a strict **MVC Architecture**, ensuring a clean separation of concerns:

### 1. Design Patterns

* **Strategy Pattern (Creation):** Implemented in the `controller.creators` package. The `ItemCreator` interface defines a common strategy for object creation, while concrete classes (`SongCreator`, `PodcastCreator`) implement specific logic.
* **Strategy Pattern (Navigation):** Implemented via the **`Menu` Interface**. All menu controllers (`AddMenu`, `SearchMenu`, etc.) implement a common `void show()` method. This allows the `MainController` to use a `Map<String, Menu>` strategy, replacing rigid switch-case logic and adhering to the **Open/Closed Principle**.
* **Polymorphism:** Utilization of an abstract base class `AudioItem` and the `PlaylistInsertable` interface to handle different object types within a single collection.
* **Generics (PECS):** The `utils` package uses Advanced Generics with **Lower Bounded Wildcards** (`? super T`), enabling utility methods to work safely across the entire inheritance hierarchy.

### 2. Package Structure

* **entity (Model):** Defines the data hierarchy (POJOs) using inheritance (`AudioItem`).
* **service (Business Logic):** Handles core operations (CRUD, Searching, Filtering logic) and ensures data safety via defensive copying.
* **controller (Controller):** Manages user input and navigates between different menus using the `Menu` interface.
* **io (Data Layer):** Handles file reading and writing (`LibraryRepository`) using OpenCSV.
* **utils (View/Helpers):** Contains `ConsolePrinter` for tabular visualization, `Validator` for input checks, and generic algorithms.

## Project Structure

```text
src
├── controller
│   ├── creators           // Factory/Strategy Pattern for object creation
│   │   ├── ItemCreator.java
│   │   ├── SongCreator.java
│   │   └── ...
│   ├── menus              // Navigation logic implementing Menu interface
│   │   ├── MainMenu.java  // Uses Map Strategy for navigation
│   │   ├── AddMenu.java
│   │   ├── FilterMenu.java
│   │   ├── SortMenu.java
│   │   └── ...
│   ├── playlist           // Specific playlist operations
│   │   ├── PlaylistAdd.java
│   │   ├── PlaylistView.java
│   │   └── ...
│   ├── InputProvider.java
│   ├── Menu.java          // Common Interface for all menus
│   └── MainController.java
├── entity                 // Data Model
│   ├── AudioItem.java     // Abstract Base
│   ├── Song.java
│   ├── PlaylistInsertable.java
│   └── ...
├── io                     // File Persistence
│   └── LibraryRepository.java
├── service                // Business Logic layer
│   └── LibraryService.java
└── utils                  // Helper classes
    ├── ConsolePrinter.java
    ├── Filter.java
    ├── Search.java
    ├── Validator.java
    └── Sort.java
