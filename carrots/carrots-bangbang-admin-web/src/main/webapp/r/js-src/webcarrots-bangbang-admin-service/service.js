'use strict';
angular.module('carrots_bangbang')

    .factory('pathProject', function (commonUtil) {
        return {
                	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                        
          
         
         
        }
    })
    
           
	    .factory('roleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.role(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.role(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.role_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.role(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.role(id));
            }
           
        }
    })
                
	    .factory('managerService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.manager(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.manager(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.manager_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.manager(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.manager(id));
            }
           
        }
    })
                
	    .factory('moduleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.module(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.module(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.module_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.module(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.module(id));
            }
           
        }
    })
                
	    .factory('roleModuleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.roleModule(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.roleModule(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.roleModule_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.roleModule(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.roleModule(id));
            }
           
        }
    })
                
	    .factory('articleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.article(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.article(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.article_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.article(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.article(id));
            }
           
        }
    })
                
	    .factory('productService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.product(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.product(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.product_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.product(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.product(id));
            }
           
        }
    })
                
	    .factory('companyService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.company(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.company(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.company_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.company(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.company(id));
            }
           
        }
    })
                
	    .factory('professionService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.profession(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.profession(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.profession_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.profession(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.profession(id));
            }
           
        }
    })
                
	    .factory('companyTagService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.companyTag(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.companyTag(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.companyTag_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.companyTag(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.companyTag(id));
            }
           
        }
    })
                
	    .factory('professionTagService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.professionTag(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.professionTag(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.professionTag_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.professionTag(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.professionTag(id));
            }
           
        }
    })
             
   
    ;






