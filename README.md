AndroidFragmentAnimations
=========================
ANDROID FRAGMENT ANIMATIONS
A great way to add some sizzle to your android app is to use the transition and animation support built into the fragment framework.

TRANSITIONS
To use one of the built-in Transitions, use the setTranstion() method:

getSupportFragmentManager()
.beginTransaction()
.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_OPEN )
.show( m_topFragment )
.commit()

CUSTOM ANIMATIONS
You can also customize the animation by using the setCustomAnimations() method:

getSupportFragmentManager()
.beginTransaction()
.setCustomAnimations( R.anim.slide_in_left, 0, 0, R.anim.slide_out_left)
.show( m_topFragment )
.commit()

MULTIPLE ANIMATIONS
Finally, It’s also possible to kick-off multiple fragment animations in a single transaction. This allows for a pretty cool effect where one fragment is sliding up and the other slides down at the same time:

getSupportFragmentManager()
.beginTransaction()
.setCustomAnimations( R.anim.abc_slide_in_top, R.anim.abc_slide_out_top ) // Top Fragment Animation
.show( m_topFragment )
.setCustomAnimations( R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom ) // Bottom Fragment Animation
.show( m_bottomFragment )
.commit()

Check out some gifs of the animations at http://swarmnyc.com/whiteboard/android-fragment-animations/
