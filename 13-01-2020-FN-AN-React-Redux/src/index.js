import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Pollution from './Pollution';
import * as serviceWorker from './serviceWorker';
import { Provider } from 'react-redux';
import { createStore } from 'redux'; // to create the store and middleware
import { fetchReducer } from './reducers'

const store = createStore(fetchReducer);//, applyMiddleware(thunk));


ReactDOM.render(
  <Provider store={store}>
    <Pollution />
  </Provider>,
  document.getElementById('root')
);

        serviceWorker.unregister();