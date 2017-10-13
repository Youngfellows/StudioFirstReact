import React, { Component } from 'react'
import { View, Text, StyleSheet } from 'react-native'

export default class extends Component {
  render() {
    return (
      <View style={styles.container}>
                <Text style={styles.text}>
                    Aispeech苏州思必驰信息科技有限公司
                </Text>
                <Text style={styles.text}>
                   1 + 1 = 10076
                </Text>
                <Text style={styles.text}>
                  欢迎学习React Native最牛逼的技术
                </Text>


      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#ffffff'
  },
  text: {
    fontSize: 20,
    color: '#333333'
  }
})
