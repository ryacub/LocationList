# Location List

## Requirements
1. Retrieve and print out the data received from the url above.
1. Parse the data retrieved from the server into a list of Java objects
1. Display your objects in a RecyclerView
1. Should display the name, city, state, and end date
1. In addition the object’s name, have your view display the image located at each object’s icon url.

# Resolution
* The data retrieval was implemented using Retrofit third party library
* the parsing was handling by the Google GSON library
* Icon Images were handled with Glide library
* the items were populated through an adapter and via Recycler view
* The venue was problematic as it returned no values and there I had set a default location.
There were no real technical difficulties besides planning out the implementation and
orchestrating it. Retrofit and Glide were chose because of the ease of use
 and common usage of these respective libraries.
 With more time I might have implemented some test methods and possibly
 a different architecture pattern.