Yes! There will be mod support, Use the .jar file as a dependency and import 'org.refinery.Modding.mod' and extend mod to create a mod!

More detailed instructions:
1. Create a java project and use any IDE of your choice.
2. Use refinery.jar as a dependency and import 'org.refinery.Modding.mod' into your main class.
3. Extend your main class with 'mod' and the game will add an 'onEnable' function, use the 'game' variable to interact with the game. (e.g. adding ground, objects or even UI!)

How to make an object:
1. Create a class and extend it with 'GameObject'.
2. Use the 'update' method which will be called every game update.
3. Use the 'getSprite' method which will be called every frame to render your object. (USE TYPE_INT_ARGB FOR PROPER RENDERING.)
4. Edit the rest how you like!

How to make and an element to the game:
    * With the 'game' variable in your 'onEnable' method
        Use 'game.getGameObjects().add();' and put a new instance of your object in the parameters of add. - adds a gameobject.
        Use 'game.getUI().add();' and put a new instance of your UI in the parameters of add. - adds a UI element.
        Grounds are not fully implemented but use 'game.getGround.add();' to add some if you want.
