# ShoppingList


First project for Mobile Development class CSC-550 (Spring 2016)<br />
<br />
Operation: Type item to be added into a EditText<br />
           Press Add Button, which uses an ArrayAdapter to add to ListView. <br />
           Toast is displayed<br />
           To remove item, tap on the item. Another toast.<br />

Features:  Landscape uses different layout than portrait<br />
           ArrayList<String> for the list is saved to the Bundle so survives onDestroy()<br />
           The EditText is the to CapsOn for the first letter<br />
           The soft keyboard is suppressed until EditText tapped using a Manifest setting<br />
