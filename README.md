Project  - NyTimes Most ppopular Article
A simple app to hit the NY Times Most Popular Articles API and show a list of articles, that shows details when items on the list are tapped
Time spent: 2 hours spent in total

We'll be using the most viewed section of this API. Note: you need to signup for an API key

at: https://developer.nytimes.com/get-started, then replace the ‘sample-key’ below with the API key assigned to your account.

http://api.nytimes.com/svc/mostpopular/v2/mostviewed/{section}/{period}.json?api-key=sample-key

To test this API, you can use all-sections for the section path component in the URL above and 7 for period (available period values are 1, 7 and 30, which represents how far back, in days, the API returns results for).

http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=sample-key


User Stories

The following required functionality is completed:

User can see news article when launching app using New York Times Search API.
User can tap on any article in results to view the contents in an embedded browser.
User can scroll down to see more articles. The maximum number of articles is limited by the API search.

Open-source libraries used

Dagger2,RxJava,Reyclerview,Cardview,OkHttp,Glide

Notes

challenges encountered while building the app.
The NYTimes API is quite slow
The rate limits of the NYTimes API are very low: 1000 calls per day, and only 1 call per second
There is an inconsistency in the NYTimes API: the geo_facet object in docs is supposed to be a JSON object, but sometimes it is returned as an empty JSON array.



