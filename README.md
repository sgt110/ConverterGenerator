ConverterGenerator 1.3.0
--------------------------
此jar由sgt魔改
--------------------------
Custom plugin for Intellij Idea for generating the converter method by matching setters and getters of given classes.
Plugin generates the converter method (code) for you in your class.

Installation
------------
Using Intellij Idea built-in system:
  - Preferences/Plugins/Browse repositories.../Search for "converter generator"/Install Plugin/Restart IDE.

Usage
------------
1. Put the caret in any place within the class, press Alt+Ins and select in menu "Generate converter method" or use shortcut Ctrl+Alt+G.
2. In the dialog select the Class you want to convert To and select the class you want to convert From.
3. Press "Ok" and converter method will be added to your current class.
4. Plugin also writes in comments list of fields, that were not mapped (appropriate setter or getter is missing or different types).

Example of the result:

     public Dto transBO2Dto(BO source) {
         if (source == null) {
            return null;
         }
         Dto target = new Dto();
         target.setName(source.getName());
         target.setAge(source.getAge());
         target.setAddress(source.getAddress());
         target.setNeighbors(source.getNeighbors());
         target.setStudent(source.getStudent());

         // Not mapped FROM fields:
         // id
         // preferredLanguage
         return target;
     } 

