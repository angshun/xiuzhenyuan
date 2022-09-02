// 'use strict';
// angular.module('carrots_bangbang')
//     .controller('articleCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, articleService) {
//
//         var vm = $scope.vm = {};
//
//          vm.params = {
//                    	     id: $state.params.id
// 	                              ,
//                      	     type: $state.params.type
// 	                              ,
//                      	     title: $state.params.title
// 	                              ,
//                      	     img: $state.params.img
// 	                              ,
//                      	     url: $state.params.url
// 	                              ,
//                      	     status: $state.params.status
// 	                              ,
//                      	     industry: $state.params.industry
// 	                              ,
//                      	     createAt: $state.params.createAt
// 	                              ,
//                      	     updateAt: $state.params.updateAt
// 	                              ,
//                      	     createBy: $state.params.createBy
// 	                	     updateBy: $state.params.updateBy
// 	                	     rank: $state.params.rank
// 	                         };
//
//
//     articleService.getList(vm.params).then(function(res) {
//         if (res.data.code === 0) {
//             vm.list = res.data.data;
//             vm.page = {
//                 next: res.data.next || 0,
//                 size: res.data.size || 0,
//                 page: res.data.page || 0,
//                 total: res.data.total || 0
//             };
//         } else {
//             $rootScope.alert(res.data.message);
//         }
//     });
//
//
//     vm.search = function() {
//
//         $state.go("field.articleList", vm.params,{reload:true});
//     };
//     });
