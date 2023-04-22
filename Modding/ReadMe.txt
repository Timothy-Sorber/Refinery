Yes! There is mod support, Use the .jar file as a dependency and import 'org.refinery.Modding.mod' and extend mod to create a mod!

More detailed instructions:
1. Create a java project using maven and use any IDE of your choice.
2. Use refinery.jar as a dependency and import 'org.refinery.Modding.mod' into your main class.
3. Extend your main class with 'mod' and the game will add an 'onEnable' function, use the 'game' variable to interact with the game. (e.g. adding ground, objects or even UI!)

How to make an object:
1. Create a class and extend it with 'GameObject'.
2. Use the 'update' method which will be called every game update.
3. Use the 'getSprite' method which will be called every frame to render your object. (USE "BufferedImage.TYPE_INT_ARGB" FOR PROPER RENDERING.)
4. Edit the rest how you like!
(the same basically goes for UI and Ground)

How to make and add element to the game:
    * With the 'game' variable in your 'onEnable' method
        Use 'game.getGameObjects().add();' and put a new instance of your object in the parameters of add. - adds a gameobject.
        Use 'game.getUI().add();' and put a new instance of your UI in the parameters of add. - adds a UI element.
        Use 'game.getGround().add();' and put a new instance of your ground  in the parameters of add. - adds a ground element.

Things you can do:
    1. Monetize your mod.
    2. Distribute your mod.
    3. Advertise your mod wherever it's allowed.
    4. Create a discord for distributing/chatting about your mod.
    * If you want another person(s) content in your mod you need permission.

things you can NOT do:
    1. Unwanted/malicious things to a players' computer.
    2. Steal personal info without the players prior permission.
    3. Have sexual or other inappropriate content contained in any of your mod files.
    4. Anything illegal.
    * If your mod is found in violation of these rules your mod will be blacklisted.
