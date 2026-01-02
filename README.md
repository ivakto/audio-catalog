# Audio Catalog Organizer

**Audio Catalog Organizer** is a robust Java console application designed for efficient management of a personal multimedia library. This project demonstrates a strong understanding of **Object-Oriented Programming**, **SOLID principles**, and the **MVC** architectural pattern.

This application allows user to organize, Song, Podcast, AudioBooks, Music Albums, and Playlists, ensuring data persistence through file storage.

## Key Features

Multi-Format Support: Create and manage various audio types: **Songs**, **Podcasts**, **Audiobooks**, **Music Albums**, and **Playlists**.

Data Persistence: Automatic saving and loading of the entire catalog from the file system, ensuring no data is lost between sessions.

Smart Search: Advanced filtering capabilities allowing users to search by Title, Author, and Genre simultaneously.

Data Integrity:Centralized **Input Validation** that prevents invalid data entry (e.g., future release years, negative duration).

playlist Dynamic Playlists: Logic for creating nested playlists and grouping different media types.

---

## Architecture & Design

The project is built upon a strict **MVC Architecture**, ensuring a clean separation of concerns:

### 1. Design Patterns
* **Strategy Pattern:** Implemented in the `controller.creators` package. The `ItemCreator` interface defines a common strategy for object creation, while concrete classes (`SongCreator`, `PodcastCreator`) implement specific logic. This adheres to the **Open/Closed Principle**, allowing new media types to be added without modifying existing code.
* **Polymorphism:** Utilization of an abstract base class `AudioItem` and the `PlaylistInsertable` interface to handle different object types within a single collection.

### 2. Package Structure
* **`entity` (Model):** Defines the data hierarchy (POJOs) using inheritance (`AudioItem`).
* **`service` (Business Logic):** Handles core operations (CRUD, Searching, Filtering logic).
* **`controller` (Controller):** Manages user input and navigates between different menus.
* **`io` (Data Layer):** Handles file reading and writing (`LibraryRepository`).
* **`utils` (View/Helpers):** Contains `ConsolePrinter` for tabular visualization and `Validator` for input checks.

---

## Project Structure

```text
src
├── controller
│   ├── creators           // Factory/Strategy Pattern for object creation
│   │   ├── ItemCreator.java
│   │   ├── SongCreator.java
│   │   └── ...
│   ├── menus              // Navigation logic
│   │   ├── AddMenu.java
│   │   ├── FilterMenu.java
│   │   ├── SortMenu.java
│   │   └── ...
│   ├── playlist           // Specific playlist operations
│   │   ├── PlaylistAdd.java
│   │   ├── PlaylistView.java
│   │   └── ...
│   ├── InputProvider.java
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
    └── Validator.java
    └── Sort.java
