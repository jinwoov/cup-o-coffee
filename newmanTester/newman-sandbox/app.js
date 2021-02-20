'use strict';

const newman = require('newman');

newman.run({
    collection: require('./collections/pc.json'),
    reporters: ['cli', 'htmlextra']
}), function (err) {
    if(err) { throw err; }
    console.log('collection run complete');
}