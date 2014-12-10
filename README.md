AndroidFragmentAnimations
=========================
ANDROID FRAGMENT ANIMATIONS<br>
A great way to add some sizzle to your android app is to use the transition and animation support built into the fragment framework.

TRANSITIONS<br>
To use one of the built-in Transitions, use the setTranstion() method:

getSupportFragmentManager()<br>
.beginTransaction()<br>
.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_OPEN )<br>
.show( m_topFragment )<br>
.commit()<br>

CUSTOM ANIMATIONS<br>
You can also customize the animation by using the setCustomAnimations() method:

getSupportFragmentManager()<br>
.beginTransaction()<br>
.setCustomAnimations( R.anim.slide_in_left, 0, 0, R.anim.slide_out_left)<br>
.show( m_topFragment )<br>
.commit()<br>

MULTIPLE ANIMATIONS<br>
Finally, It’s also possible to kick-off multiple fragment animations in a single transaction. This allows for a pretty cool effect where one fragment is sliding up and the other slides down at the same time:

getSupportFragmentManager()<br>
.beginTransaction()<br>
.setCustomAnimations( R.anim.abc_slide_in_top, R.anim.abc_slide_out_top ) // Top Fragment Animation<br>
.show( m_topFragment )<br>
.setCustomAnimations( R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom ) // Bottom Fragment Animation<br>
.show( m_bottomFragment )<br>
.commit()<br>

Check out some gifs of the animations at http://swarmnyc.com/whiteboard/android-fragment-animations/
