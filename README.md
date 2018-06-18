# NewsApp
Android application that downloads news articles and stores user's favorite articles in Realm database.

# Overview
The app does the following:
  1. It consumes https://newsapi.org at startup.
  2. Display the list of news with their title and a button allowing the user to save his favorite news.
  3. It has a TabLayout with two TabItems that allows the user to switch between news from the API and his favorite news.
  4. The favorite news are getting stored into a Realm database for persistence.
  5. When user clicks a listItem, whether on the News List or the Favorite News list, it'll open a WebView displaying the full new.

# Libraries
This app leverages two thir-party libraries:
 - Dagger 2 - For DI and MVP.
 - Realm - For data persistence.
