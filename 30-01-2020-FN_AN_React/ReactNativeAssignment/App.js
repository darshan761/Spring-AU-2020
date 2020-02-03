import * as React from 'react';
import { AppRegistry } from 'react-native';
import SplashScreen from 'react-native-splash-screen'
import {createAppContainer, Navigator} from 'react-navigation';
import {createStackNavigator} from 'react-navigation-stack';
import HomeScreen from './HomeScreen';

// creating navigation
const MainNavigator  = createStackNavigator({
  Home: {screen: HomeScreen,
    navigationOptions: {
      header: null,
    }
  }
});



const App = createAppContainer(MainNavigator);
export default App;