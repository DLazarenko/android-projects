# android-projects
App allows to search through Flickr, using specific tags, and see the results (images and details) on a screen. 
For full image to be viewed  - tap the thumbnail.



AsyncTask explanation 
2 approaches which can be used:

1. MainActivity starts GetRawData on a background thread, and waits to get a response.  It then parses the data on a background thread (and again waits until it gets a response).

2. MainActivity starts the parser on a background thread.  The parser starts GetRawData, and parses the downloaded data when GetRawData finishes.

Generally, better to avoid having tight coupling between classes.  Option 1 for the case if the parsing class doesn't have to know about the class that does the downloading.

Other times, the application doesn't know where the data's coming from. The application uses a ContentResolver class to request data, but has no idea whether the data's coming from the local file system, a database, or over the internet.

The GetRawData class in the app can be executed on a background thread by the main Activity, or called by something that's already running on a background thread.
