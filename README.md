# Styled-Map-Pager 

Styled Map Pager is an awesome first of its type android library for showing a multiple location with different pins along with custom style on a google map with view pager.

It highlights selected location with unique marker pin. It give prominence to certain marker with needs to be highlighted which are selected by you. Also displays selected location in center of screen. Markers are changed with map zoom in and zoom out effects. 

Main thing is that this all is binding with pager slider. With sliding of pager map locations are also moves.

<img src="https://github.com/Bhoomika06/Styled-Map-Pager/blob/master/Screenshot_1490693370.png" alt text="Screenshot" width="240" height="427" />  <img src="https://github.com/Bhoomika06/Styled-Map-Pager/blob/master/Screenshot_1490698948.png" alt text="Screenshot" width="240" height="427" />

# Download

# Using Gradle: under dependencies section:   
  ***Step 1.*** Add it in your root build.gradle at the end of repositories:
```java
  allprojects {
		 repositories {
			...
			 maven { url 'https://jitpack.io' }
		 }
	 }
 ```
 
 ***Step 2.*** Add the dependency
```java
 dependencies {
		compile 'com.github.Bhoomika06:Styled-Map-Pager:1.0.0'
	}
```

# or Using Maven:
    <dependency>
        <groupId>com.github.aarsy.googlemapsanimations</groupId>
        <artifactId>googlemapsanimations</artifactId>
        <version>1.0.5</version>
        <type>pom</type>
    </dependency>

# Usage

```java
// map is GoogleMap object, latLng is the location on map from which ripple should start

CustomMap customMap = new CustomMap(map, yourLatLngsArrayList, YourActivity.this);
customMap.setCustomMapStyle(R.raw.mapstyle); // by this you can set styles to your map where mapstyle is .json file which is                                                 inside your assets folder
```

```java
// for adding multiple markers inside your app
customMap.addCustomPin();
```

```
// for display selected pin with pager's current selected item
 customMap.addSelectedCustomPin(position); // position is your pager's current selected pager item
```

# License

```
Copyright © 2017 by Bhoomika Patel

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
