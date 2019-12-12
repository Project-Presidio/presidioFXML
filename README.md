# presidioFXML
JavaFX implementation of Presidio using FXML designs 

## Building Presidio
Presidio is written using Netbeans 8.x and uses Ant as its build system. 


## JSON Question format
Below is the format for questions on the questionList
```
{
  "0": {
    "id": 0,
    "title": "What best describes your current situation?",
    "response": {
      "a": "Seismic",
      "b": "Flood",
      "c": "Inclement Weather",
      "d": "Emergency"
    },
    
    "redirect":{
      "a": 1,
      "b": 1,
      "c": 1,
      "d": 1
    }
  },
  "1": {
    "id": 1,
    "title": "Is this a true false question?",
    "response": {
      "a": "Yes",
      "b": "No"
    },
    
    "redirect":{
      "a": -1,
      "b": -2
    }
  }
}
```
