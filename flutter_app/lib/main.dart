// ignore: avoid_web_libraries_in_flutter
import 'dart:html';

import 'package:flutter/material.dart';

//The main function is the starting point of the project.
void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('I am rich'),
          backgroundColor: Colors.blueGrey[900],
        ),
        backgroundColor: Colors.pink[50],
        body: Center(
            child: Image(
          image: AssetImage('images/2015-05-23 08.11.39.jpg'),
        )),
      ),
    ),
  );
}
