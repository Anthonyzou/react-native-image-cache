/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */
'use strict';
import React, {
  AppRegistry,
  Component,
  StyleSheet,
  Text,
  View,
  Dimensions,
  TextInput,
  ToastAndroid,
} from 'react-native';

import Image from './cache'
import {Actions, Router, Route, Schema, Animations, TabBar} from 'react-native-router-flux'
class Example extends Component {
  constructor(a,b){
    super(a,b)
    this.state = {
      text:'http://placehold.it/400'
    }
  }
  render() {
    return (
      <View style={styles.container}>
        <Text>Image cache example</Text>
        <TextInput onChangeText={(text) => this.setState({text:text})} value={this.state.text}></TextInput>
        <Image onLoad={()=>{

          ToastAndroid.show(`OnLoad ${this.state.text}`, ToastAndroid.LONG)
        }} borderRadius={2} style={styles.image} src={this.state.text}></Image>
      </View>
    );
  }
}

class main extends Component{
  render(){
    return (
      <Router hideNavBar={true}>
        <Route name="Main" type="reset" component={Example}/>
      </Router>
    )
  }
}
const {height, width} = Dimensions.get('window');
const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  image:{
    width: width,
    flex:1,
  }
});

AppRegistry.registerComponent('example', () => main);
