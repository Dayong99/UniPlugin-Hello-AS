!function(t){var e={};function n(o){if(e[o])return e[o].exports;var r=e[o]={i:o,l:!1,exports:{}};return t[o].call(r.exports,r,r.exports,n),r.l=!0,r.exports}n.m=t,n.c=e,n.d=function(t,e,o){n.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:o})},n.r=function(t){"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},n.t=function(t,e){if(1&e&&(t=n(t)),8&e)return t;if(4&e&&"object"==typeof t&&t&&t.__esModule)return t;var o=Object.create(null);if(n.r(o),Object.defineProperty(o,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)n.d(o,r,function(e){return t[e]}.bind(null,r));return o},n.n=function(t){var e=t&&t.__esModule?function(){return t.default}:function(){return t};return n.d(e,"a",e),e},n.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},n.p="",n(n.s=8)}([function(t,e,n){"use strict";var o=n(5),r=n(2),i=n(7);var u=Object(i.a)(r.default,o.b,o.c,!1,null,null,"01abfb7c",!1,o.a,void 0);(function(t){this.options.style||(this.options.style={}),Vue.prototype.__merge_style&&Vue.prototype.__$appStyle__&&Vue.prototype.__merge_style(Vue.prototype.__$appStyle__,this.options.style),Vue.prototype.__merge_style?Vue.prototype.__merge_style(n(6).default,this.options.style):Object.assign(this.options.style,n(6).default)}).call(u),e.default=u.exports},function(t,e){t.exports={"@VERSION":2}},function(t,e,n){"use strict";var o=n(3),r=n.n(o);e.default=r.a},function(t,e,n){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n={data:function(){return{}},onLoad:function(){},methods:{testAdd:function(){t("sn-testmodule").add({a:22,b:3},(function(t){uni.showToast({title:JSON.stringify(t),icon:"none"})}))},getAHCA:function(){var e;e=JSON.stringify("cd235b7e970c4ae2bdd350becc77158c"),t("sn-testmodule").getLocalCert({mobileUserId:e},(function(t){uni.showToast({title:JSON.stringify(t),icon:"none"})}))},applyAHCA:function(){var e;e=JSON.stringify("cd235b7e970c4ae2bdd350becc77158c"),t("sn-testmodule").applyCompanyCert({mobileUserId:e},(function(t){uni.showToast({title:JSON.stringify(t),icon:"none"})}))}}};e.default=n}).call(this,n(11).default)},function(t,e){t.exports={".content":{"":{display:["flex",0,0,0],flexDirection:["column",0,0,0],alignItems:["center",0,0,0],justifyContent:["center",0,0,0]}},"@VERSION":2}},function(t,e,n){"use strict";n.d(e,"b",(function(){return o})),n.d(e,"c",(function(){return r})),n.d(e,"a",(function(){}));var o=function(){var t=this.$createElement,e=this._self._c||t;return e("scroll-view",{staticStyle:{flexDirection:"column"},attrs:{scrollY:!0,showScrollbar:!0,enableBackToTop:!0,bubble:"true"}},[e("view",{staticClass:["content"]},[e("button",{attrs:{type:"default"},on:{click:this.testAdd}},[this._v("22+3=")]),e("button",{attrs:{type:"default"},on:{click:this.getAHCA}},[this._v("\u83b7\u53d6AHCA\u8bc1\u4e66")]),e("button",{attrs:{type:"default"},on:{click:this.applyAHCA}},[this._v("\u7533\u8bf7AHCA\u8bc1\u4e66")])],1)])},r=[]},function(t,e,n){"use strict";n.r(e);var o=n(4),r=n.n(o);for(var i in o)"default"!==i&&function(t){n.d(e,t,(function(){return o[t]}))}(i);e.default=r.a},function(t,e,n){"use strict";function o(t,e,n,o,r,i,u,s,c,l){var a,f="function"==typeof t?t.options:t;if(c){f.components||(f.components={});var p=Object.prototype.hasOwnProperty;for(var d in c)p.call(c,d)&&!p.call(f.components,d)&&(f.components[d]=c[d])}if(l&&((l.beforeCreate||(l.beforeCreate=[])).unshift((function(){this[l.__module]=this})),(f.mixins||(f.mixins=[])).push(l)),e&&(f.render=e,f.staticRenderFns=n,f._compiled=!0),o&&(f.functional=!0),i&&(f._scopeId="data-v-"+i),u?(a=function(t){(t=t||this.$vnode&&this.$vnode.ssrContext||this.parent&&this.parent.$vnode&&this.parent.$vnode.ssrContext)||"undefined"==typeof __VUE_SSR_CONTEXT__||(t=__VUE_SSR_CONTEXT__),r&&r.call(this,t),t&&t._registeredComponents&&t._registeredComponents.add(u)},f._ssrRegister=a):r&&(a=s?function(){r.call(this,this.$root.$options.shadowRoot)}:r),a)if(f.functional){f._injectStyles=a;var _=f.render;f.render=function(t,e){return a.call(e),_(t,e)}}else{var y=f.beforeCreate;f.beforeCreate=y?[].concat(y,a):[a]}return{exports:t,options:f}}n.d(e,"a",(function(){return o}))},function(t,e,n){"use strict";n.r(e);n(9);var o=n(0);"undefined"==typeof Promise||Promise.prototype.finally||(Promise.prototype.finally=function(t){var e=this.constructor;return this.then((function(n){return e.resolve(t()).then((function(){return n}))}),(function(n){return e.resolve(t()).then((function(){throw n}))}))}),o.default.mpType="page",o.default.route="pages/index/index",o.default.el="#root",new Vue(o.default)},function(t,e,n){Vue.prototype.__$appStyle__={},Vue.prototype.__merge_style&&Vue.prototype.__merge_style(n(10).default,Vue.prototype.__$appStyle__)},function(t,e,n){"use strict";n.r(e);var o=n(1),r=n.n(o);for(var i in o)"default"!==i&&function(t){n.d(e,t,(function(){return o[t]}))}(i);e.default=r.a},function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=function(t){return weex.requireModule(t)}}]);