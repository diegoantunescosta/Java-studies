import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:fresquinha/api/funtion.dart';
import 'package:http/http.dart' as http;

class Homepage extends StatefulWidget {
  const Homepage({Key? key}) : super(key: key);

  @override
  _HomepageState createState() => _HomepageState();
}

class _HomepageState extends State<Homepage> {
  Createddata obj = Createddata();
  TextEditingController nameController = TextEditingController();
  TextEditingController emailController = TextEditingController();
  TextEditingController cityController = TextEditingController();

  @override
  void initState() {
    super.initState();
    getdata();
    datadelet(id);
    obj.datacreated(
        nameController.text, emailController.text, cityController.text);
  }

  List data = [];
  String? id;

  Future getdata() async {
    final responce =
        await http.get(Uri.parse('http://localhost:8080/categorias/'));
    if (responce.statusCode == 200) {
      setState(() {
        data = jsonDecode(responce.body);
      });
      print('Add data$data');
    } else {
      print('erro');
    }
  }

  Future datadelet(id) async {
    final responce =
        await http.delete(Uri.parse('http://localhost:8080/categorias/$id'));
    print(responce.statusCode);

    if (responce.statusCode == 200) {
      print('DELETE COMPLETE');
    } else {
      print('nOT dELET');
    }
  }

  Future update() async {
    final responce =
        await http.put((Uri.parse('http://localhost:8080/categorias')),
            body: jsonEncode({
              "name": nameController.text,
              "email": emailController.text,
            }),
            headers: {
          'Content-type': 'application/json; charset=UTF-8',
        });
    print(responce.statusCode);
    if (responce.statusCode == 200) {
      print('Data Update Sucassfully');
      nameController.clear();
      //  emailController.clear();
    } else {
      print('erro');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Container(
            child: Column(
              children: [
                TextField(
                  controller: nameController,
                  decoration: InputDecoration(
                    hintText: 'Name',
                  ),
                ),
                TextField(
                  controller: emailController,
                  decoration: InputDecoration(
                    hintText: 'email',
                  ),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    ElevatedButton(
                        onPressed: () {
                          setState(() {
                            obj.datacreated(nameController.text,
                                emailController.text, cityController.text);
                          });
                        },
                        child: Text('Enviar')),
                    ElevatedButton(
                        onPressed: () {
                          setState(() {
                            update();
                          });
                        },
                        child: Text('Alterar')),
                  ],
                ),
                Expanded(
                  child: ListView.builder(
                      itemCount: data.length,
                      itemBuilder: (context, index) {
                        return Container(
                          child: ListTile(
                            title: Text(data[index]['name']),
                            //     subtitle: Text(data[index]['email']),
                            trailing: Container(
                              width: 100,
                              child: Row(
                                children: [
                                  IconButton(
                                      onPressed: () {
                                        nameController.text =
                                            data[index]['name'];
                                        //         emailController.text =
                                        //            data[index]['email'];
                                      },
                                      icon: Icon(Icons.edit)),
                                  IconButton(
                                      onPressed: () {
                                        setState(() {
                                          datadelet(data[index]['id']);
                                        });
                                      },
                                      icon: Icon(Icons.delete))
                                ],
                              ),
                            ),
                          ),
                        );
                      }),
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
