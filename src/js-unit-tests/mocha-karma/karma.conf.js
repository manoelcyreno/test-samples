const path = require('path');
const webpackConfig = require('./webpack.config');

module.exports = function (config) {
    config.set({
        browsers: ['Chrome'],

        client: {
            mocha: {
                timeout: 4000
            }
        },

        files: [
            'node_modules/babel-polyfill/dist/polyfill.js',
            'test/*.js'
        ],

        frameworks: ['mocha', 'chai'],

        plugins: [
            'karma-chai',
            'karma-chrome-launcher',
            'karma-mocha',
            'karma-babel-preprocessor',
            'karma-webpack',
        ],

        preprocessors: {
            './index.js': ['webpack'],
            './test/*.js': ['webpack']
        },

        webpack: webpackConfig,

        port: 9876,

        colors: true,

        logLevel: config.LOG_INFO,

        autoWatch: false,

        singleRun: true,
    })
}