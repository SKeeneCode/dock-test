# dock-test

A quick minimal example to show an error when trying to allow the user to programatically add tabs.

Run the example, the user can click the buttons in each tab freely without errors.

However when you press the buttons on the left, which try to add many tabs insequence:

`

addTabsQuicklyButton.setOnAction(event -> {

            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
            
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
            
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
            
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
            
        });
        
`
        
and

`
addTabsQuicklyButton2.setOnAction(event -> {
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
            tabPane.placeTab(createTab(), Pos.TOP_CENTER);
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
        });
`

the later causes an error which is what I want to fix.

![image](https://user-images.githubusercontent.com/32420836/133004136-0d0b8555-949c-433d-b401-f87291d2e873.png)
