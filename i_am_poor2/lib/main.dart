import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(
        title: Text('I am poor'),
        backgroundColor: Colors.pink[50],
      ),
      body: Center(
        child: Image(image: AssetImage('images/coal.png')),
      ),
    ),
  ));
}
