import * as React from 'react';

import { AppRegistry, TouchableWithoutFeedback, SafeAreaView, View, FlatList, Text, StyleSheet, Dimensions, Image} from 'react-native';
import { TabView, SceneMap } from 'react-native-tab-view';

// for returning view to flat list
function Item({ name, author, image }) {
      
    var imgsrc;
    switch (image) {
      case 'mooe':
          imgsrc = require('./images/mooe.jpeg');
          break;
      case 'reb':
          imgsrc = require('./images/reb.jpeg');
          break;
      case 'tdvc':
          imgsrc = require('./images/tdvc.jpeg');
          break;
      case 'fios':
            imgsrc = require('./images/fios.jpeg');
            break;
      case 'psilu':
            imgsrc = require('./images/psilu.jpeg');
            break;
      case 'awtr':
            imgsrc = require('./images/awtr.jpeg');
            break;
      case 'rdpd':
            imgsrc = require('./images/rdpd.jpeg');
            break;
      case 'sec':
            imgsrc = require('./images/sec.jpeg');
            break;
      case 'tfa':
            imgsrc = require('./images/tfa.jpeg');
            break;
      }
  

    return (
      <TouchableWithoutFeedback >
      <View style={style1.item}>
            <Text style={style1.title}>{ name}</Text>
            <Text style={style1.author}>{author}</Text>
            {<Image
                style={{padding:20, marginTop:10, width: 350, height: 500, borderRadius: 20}}
                source={imgsrc}
              /> }
      </View>
      </TouchableWithoutFeedback>
      
    );
  }
  
  // for first tab
  const  FirstRoute = () => (
     
        <SafeAreaView style={style1.container}>
        <FlatList
          data={books.mystery}
          renderItem={({ item }) => <Item name={item.name} author={item.author} image={item.img} />}
          keyExtractor={item => item.genre}
          
        />
      </SafeAreaView>
     
  );
   
  // for second tab
  const SecondRoute = () => (
    // return (
      <SafeAreaView style={style1.container}>
        <FlatList
          data={books.romance}
          renderItem={({ item }) => <Item name={item.name} author={item.author} image={item.img}/>}
          keyExtractor={item => item.genre}
        />
      </SafeAreaView>
    // );
  );
   
  // for third tab
  const ThirdRoute = () => (
    // return (
      <SafeAreaView style={style1.container}>
        <FlatList
          data={books.selfhelp}
          renderItem={({ item }) => <Item name={item.name} author={item.author} image={item.img}/>}
          keyExtractor={item => item.genre}
        />
      </SafeAreaView>
    // );
  );
  
  
const initialLayout = { width: Dimensions.get('window').width };

// read data from books.json
const books = require('./books.json');

export default function TabViewExample() {
    const [index, setIndex] = React.useState(0);
    const [routes] = React.useState([
      { key: 'first', title: 'Mystery' },
      { key: 'second', title: 'Romance' },
      {key: 'third', title: 'Self Help'},
    ]);
   
    const renderScene = SceneMap({
      first:  FirstRoute,
      second: SecondRoute,
      third: ThirdRoute,
    });
   
    return (
      <TabView
        navigationState={{ index, routes }}
        renderScene={renderScene}
        onIndexChange={setIndex}
        initialLayout={initialLayout}
      />
    );
  }

// style
  const styles = StyleSheet.create({
        scene: {
          flex: 1,
        },
      });
      
      const style1 = StyleSheet.create({
        container: {
          flex: 1,
          backgroundColor: '#ff0266',
        //   marginTop: Constants.statusBarHeight,
        },
        item: {
          backgroundColor: '#03dac5',
          padding: 20,
          marginVertical: 8,
          borderRadius:20,
          marginHorizontal: 16,
        },
        title: {
          fontSize: 32,
          fontWeight:"bold",
        },
        author:{
          fontSize: 24,
        }
      });