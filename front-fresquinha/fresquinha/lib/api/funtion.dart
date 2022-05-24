import 'dart:convert';

import 'package:http/http.dart' as http;

class Createddata {
  get id => null;

  Future datacreated(
    nametext,
    emailtext,
    citytext,
  ) async {
    final responce =
        await http.post(Uri.parse('http://localhost:8080/categorias'),
            body: jsonEncode({
              "id": id,
              "name": nametext,
              "username": emailtext,
              "city": citytext,
            }),
            headers: {
          'Content-type': 'application/json; charset=UTF-8',
        });
    print(responce.statusCode);
    if (responce.statusCode == 201) {
      print('Data Created Successfully');
    } else {
      print('erro');
    }
  }
}
