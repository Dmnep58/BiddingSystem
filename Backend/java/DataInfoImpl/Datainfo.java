package DataInfoImpl;


import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.biddingsystem.model.Bid;
import com.biddingsystem.model.Bidder;
import com.biddingsystem.model.Products;
import com.biddingsystem.model.Transaction;
import com.biddingsystem.utill.DBConnect;

public class Datainfo {

	public static Connection connection= null;
	public static PreparedStatement  statement = null;
	
	
	// get all sellers details
	 public List<Transaction> getAllTransactions() {
	        List<Transaction> transactions = new ArrayList<>();

	        try {
	            connection = DBConnect.getConnection();
	            String sql="SELECT * FROM sellers";

	            statement = connection.prepareStatement(sql);
	            ResultSet rs = statement.executeQuery();

	            while (rs.next()) {
	                Transaction transaction = new Transaction(); 	
	                		transaction.setSellerid(rs.getInt("Seller_id"));
	                		transaction.setSname(rs.getString("sname"));
	                		transaction.setScontact(rs.getString("scontact"));
	                	    transaction.setSaddress(rs.getString("saddress"));
	                		transaction.setSemail(rs.getString("semail"));
	                		transaction.setSpassword(rs.getString("spassword"));
	                		
	                transactions.add(transaction);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return transactions;
	    }
	 
	 
	 
	 // get all bidders details
	 public List<Bidder> getAllBidders() {
	        List<Bidder> bidders = new ArrayList<>();

	        try {
	            connection = DBConnect.getConnection();
	            String sql="SELECT Bidderid,name,email,contact FROM Bidder";
	            statement = connection.prepareStatement(sql);
	            ResultSet rs = statement.executeQuery();

	            while (rs.next()) {
	            	Bidder bidder = new Bidder();
	            	bidder.setBidderid(rs.getInt("Bidderid"));
	            	bidder.setName(rs.getString("name"));
	            	bidder.setEmail(rs.getString("email"));
	            	bidder.setContact(rs.getInt("contact"));
	                
	            	bidders.add(bidder);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return bidders;
	    }
	 
	 
	 // extract the image from the database for products.
	
	 public List<Products> getAllProducts(){
		 List<Products> products = new ArrayList<>();
		 Connection connection = null;
		 String sql = "select productid,productname,category,starting_bp,description,image from newproduct";
		 try {
			 connection = DBConnect.getConnection();
			 
			statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 
			 while(resultSet.next()) {
				 Products product = new Products();
				 product.setProductid(resultSet.getInt("productid"));
				 product.setProductname(resultSet.getString("productname"));			
				 product.setProductcategory(resultSet.getString("category"));
				 product.setStarting_bp(resultSet.getString("starting_bp"));
				 product.setProductdescription(resultSet.getString("description"));
				 product.setImage("E:" +File.separator+"d"+File.separator+"nepbid"+File.separator+"src"+File.separator+"main"+File.separator
			        		+"webapp"+File.separator+"assets"+File.separator+File.separator+"productimages"+File.separator+resultSet.getString("image"));
				 products.add(product);
				 
			 }
		 }
		 catch ( Exception e ) {
			// TODO: handle exception
		}
		 
		 finally {
	            try {
	                connection.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		 
		 return products;
		 
	 }
	 
	 
	// extract the Seller products.
		
		 public List<Products> getAllSellerProducts(long sellerid){
			 List<Products> products = new ArrayList<>();
			 Connection connection = null;
			 String sql = "select productid,productname,category,starting_bp,description,image from newproduct where sellerid = ?";
			 try {
				 connection = DBConnect.getConnection();
				 
				statement = connection.prepareStatement(sql);
				statement.setLong(1, sellerid);
				 ResultSet resultSet = statement.executeQuery();
				 
				 while(resultSet.next()) {
					 Products product = new Products();
					 product.setProductid(resultSet.getInt("productid"));
					 product.setProductname(resultSet.getString("productname"));			
					 product.setProductcategory(resultSet.getString("category"));
					 product.setStarting_bp(resultSet.getString("starting_bp"));
					 product.setProductdescription(resultSet.getString("description"));
					 product.setImage("assets"+File.separator+"productimages"+File.separator+resultSet.getString("image"));
					 products.add(product);
					 
				 }
			 }
			 catch ( Exception e ) {
				// TODO: handle exception
			}
			 
			 finally {
		            try {
		                connection.close();
		                statement.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
			 
			 return products;
			 
		 }
		 
		 
	 // update password
	 public boolean match(String pass , String pass2) {
		return pass.equals(pass2); 
	 }
	 
	 
	 
	 // fetch password for admin
	 public String fetchpassword(String id) {
		 String pass="";
		 
		 try {
			connection = DBConnect.getConnection();
			String sqlString = "select Adminpassword from admin where Adminusername=?";
			statement = connection.prepareStatement(sqlString);
			
			statement.setString(1, id);
			
			ResultSet resultSet =  statement.executeQuery();
			while(resultSet.next()) {
				pass=resultSet.getString("Adminpassword");
			}
			
		} catch (SQLException e) {
		}
		 
		 return pass;
	 }
	 
	 
	 
	 // update admin password
	 public void Updatepass(String s,String id) {
		 String p = "update admin set Adminpassword='"+s+"' where Adminusername ='"+id+"'";
		 
		 try {
			 connection = DBConnect.getConnection();
			 Statement stmt = connection.createStatement();
			 stmt.executeUpdate(p);
			
		} catch (SQLException e) {
		}
		 finally {
	            try {
	                connection.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	 }
	 
	 
	 
	 
	 
	// fetch all data from product tables
	 public Products getAllProductsDetails(int id){
		 Products product = new Products();
		 String sql = "select * from newproduct where productid='"+id+"'";
		 try {
			 connection = DBConnect.getConnection();
			 
			 statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 
			 while(resultSet.next()) {
				 product.setProductid(resultSet.getInt("productid"));
				 product.setProductname(resultSet.getString("productname"));
				 product.setProductdescription(resultSet.getString("description"));
				 product.setStarting_bp(resultSet.getString("starting_bp"));
				 product.setImage("assets"+File.separator+"productimages"+File.separator+resultSet.getString("image"));
				 product.setProductcategory(resultSet.getString("category"));
				 
			 }
		 }
		 catch ( Exception e ) {
			// TODO: handle exception
		}
		 
		 finally {
	            try {
	                connection.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		 
		 
		 return product;
	 }
	 
	 
	 
	 
	 
	 // fetch the data from the bids tables
	 public List<Bid> getAllBids(){
		 List<Bid> tBids = new ArrayList<>();
		 String string = "select productid,bidderid,bidamount,status from bids where status='"+"pending"+"'";
		 
		 try {
			connection =DBConnect.getConnection();
			statement = connection.prepareStatement(string);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Bid bid = new Bid();
				int id =resultSet.getInt("productid");
				bid.setPid(id);
				bid.setBid(resultSet.getInt("bidderid"));
				bid.setBidamount(resultSet.getInt("bidamount"));
				bid.setStatus(resultSet.getString("status"));
				bid.setSid(seller(id));
				tBids.add(bid);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		 
		 finally {
	            try {
	                connection.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } 
		 return tBids;
	 }
	 
	 
	 
	 
	 //fetch seller id	 
	public int seller(int pid) {
		int sid=0;
		
		String string = "select sellerid from newproduct where productid = ?";
		
		try {
			connection = DBConnect.getConnection();
			statement = connection.prepareStatement(string);
			statement.setInt(1, pid);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				sid = resultSet.getInt("sellerid");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return sid;
		
	}
	
	
	
	
	//fetch amount from product id
	public static boolean amount(long bidamount,int pid) {
		boolean istrue = false;
		String string = "select bidamount from bids where productid =?";
		try {
			 connection = DBConnect.getConnection();
			statement= connection.prepareStatement(string);
			
			statement.setInt(1, pid);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int a = resultSet.getInt("bidamount");
				if(bidamount >= a) {
					istrue = true;
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return istrue;
	}
	
	
	
	
	//find product
	public static boolean findid(int id) {
		boolean istrue = false;
		String string = "select * from bids where productid =?";
		try {
			connection = DBConnect.getConnection();
			statement= connection.prepareStatement(string);
			
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				istrue = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return istrue;
	}
	
	
	
	
	// after allotment
	public boolean allotment(int id) {
		boolean istrue = false;
		String string = "update bids set status= ? where productid =?";
		try {
			connection = DBConnect.getConnection();
			statement= connection.prepareStatement(string);
			
			statement.setString(1, "alloted");
			statement.setInt(2, id);
			
			int  rew = statement.executeUpdate();
			
			if(rew == 1) {
				istrue = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return istrue;
	}
	
	
	
	
	//reverse
	public boolean noallotment(int id) {
		boolean istrue = false;
		String string = "update bids set status=? where productid =?";
		try {
			connection = DBConnect.getConnection();
			statement= connection.prepareStatement(string);
			
			statement.setString(1, "notalloted");
			statement.setInt(2, id);
			
			int  rew = statement.executeUpdate();
			
			if(rew == 1) {
				istrue = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return istrue;
	}
	
	
	
	
	//extract status
	public static String status(int id) {
		String s ="";
		String string = "select status from bids where productid="+id+"";
		try {
			connection = DBConnect.getConnection();
			statement= connection.prepareStatement(string);
			
		     ResultSet resultSet= statement.executeQuery();
			
			if(resultSet.next()) {
				s = resultSet.getString("status");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return s;
	}
	
	
	
	// get the product name and seller id from product id
	public String prname(int id){
		String s = "";
		
		String query = "select productname from newproduct where productid=?";
		
		try {
			connection = DBConnect.getConnection();
			statement= connection.prepareStatement(query);
			
			statement.setInt(1, id);
		     ResultSet resultSet= statement.executeQuery();
			
			if(resultSet.next()) {
				s= resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return s;
	}
	
	
	
	
	// get all bids status for the bidder id's
	public List<Bid> getAllBidsStatus(int ids ){
		
		 List<Bid> tBids = new ArrayList<>();
		 String string = "select productid,bidderid,bidamount,status from bids where bidderid = ? ";
		 
		 try {
			connection =DBConnect.getConnection();
			statement = connection.prepareStatement(string);
			statement.setInt(1, ids);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Bid bid = new Bid();
				int id =resultSet.getInt("productid");
				bid.setPid(id);
				bid.setProductname(prname(id));
				bid.setBid(resultSet.getInt("bidderid"));
				bid.setBidamount(resultSet.getInt("bidamount"));
				bid.setStatus(resultSet.getString("status"));
				bid.setSid(seller(id));
				tBids.add(bid);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		 
		 finally {
	            try {
	                connection.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		 
		 
		 return tBids;
	}
	
	
	
	// fetch the top products 
	public Products topProducts(){ 
		Products product = new Products();
		String string =" select * from newproduct where productid = (select productid from bids b1 where 3-1 = (select count(Distinct(b2.bidamount)) from bids b2 where b2.bidamount > b1.bidamount))";
		
		
		try {
			connection = DBConnect.getConnection();
			statement = connection.prepareStatement(string);
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				product.setProductid(resultSet.getInt("productid"));
				 product.setProductname(resultSet.getString("productname"));			
				 product.setProductcategory(resultSet.getString("category"));
				 product.setStarting_bp(resultSet.getString("starting_bp"));
				 product.setBidtime(resultSet.getString("bidtime"));
				 product.setProductdescription(resultSet.getString("description"));
				 product.setImage("assets"+File.separator+"productimages"+File.separator+resultSet.getString("image"));
				 
				 
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return product;
	} 
	
	
	// fetch the number of product bidder and sellers
	public int fetchproduct() {
		int count = 0;
		
		String query = "select count(*) from newproduct";
		
		try {
			connection = DBConnect.getConnection();
			statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				count = resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		
		return count;
	}
	
	
	
	// fetch total numbers of sellers
	public int fetchseller() {
		int count = 0;
		
		String query = "select count(*) from sellers";
		
		try {
			connection = DBConnect.getConnection();
			statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				count = resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		
		return count;
	}
		
	
	
	// fetch total number of bidders
	public int fetchBidder() {
		int count = 0;
		
		String query = "select count(*) from Bidder";
		
		try {
			connection = DBConnect.getConnection();
			statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				count = resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		
		return count;
	}


	
	// fetch sellers password
	public String fetchSellerpassword(int parseInt) {
		String pass="";
		
		String query = "select spassword from sellers where Seller_id=?";
		try {
			connection = DBConnect.getConnection();
			statement = connection.prepareStatement(query);
			
			statement.setInt(1,parseInt);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				pass = resultSet.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return pass;
	}


	
	// update the sellers password
	public void UpdateSellerpass(String newpassword, String id) {
      String p = "update sellers set spassword ='"+newpassword+"' where Seller_id='"+Integer.parseInt(id)+"'";
		 
		 try {
			 connection = DBConnect.getConnection();
			 Statement stmt = connection.createStatement();
			 
			 stmt.executeUpdate(p);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		 finally {
	            try {
	                connection.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
	
	
	
	// fetch seller name
	public String sellername(int id) {
		String name="";
		String query= "select sname from sellers where Seller_id=?";
		 try {
			 connection = DBConnect.getConnection();
				statement = connection.prepareStatement(query);
				
				statement.setInt(1,id);
				ResultSet resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					name = resultSet.getString(1);
				}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		 finally {
	            try {
	                connection.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		
		
		return name;
	}
	
	
	// fetch bidders password
		public String fetchBidderspassword(int parseInt) {
			String pass="";
			
			String query = "select password from bidder where bidderid=?";
			try {
				connection = DBConnect.getConnection();
				statement = connection.prepareStatement(query);
				
				statement.setInt(1,parseInt);
				ResultSet resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					pass = resultSet.getString(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally {
	            try {
	                connection.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
			
			return pass;
		}

		

		// update the bidders password
		public void UpdateBidderpass(String newpassword, String id) {
	      String p = "update bidder set password ='"+newpassword+"' where bidderid='"+Integer.parseInt(id)+"'";
			 
			 try {
				 connection = DBConnect.getConnection();
				 Statement stmt = connection.createStatement();
				 
				stmt.executeUpdate(p);
				
			} catch (SQLException e) {
				// TODO: handle exception
			}
			 finally {
		            try {
		                connection.close();
		                statement.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		}
		
		
		
		// fetch seller name
		public String biddername(int id) {
			String name="";
			String query= "select name from bidder where bidderid=?";
			 try {
				 connection = DBConnect.getConnection();
					statement = connection.prepareStatement(query);
					
					statement.setInt(1,id);
					ResultSet resultSet = statement.executeQuery();
					
					while(resultSet.next()) {
						name = resultSet.getString(1);
					}
				
			} catch (SQLException e) {
			}
			 finally {
		            try {
		                connection.close();
		                statement.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
			
			
			return name;
		}



		
		// search the products bided by the bidder
		public static List<Bid> searchBids(int id, String searchTerm) {
		    List<Bid> searchResults = new ArrayList<Bid>();

		    try {
		        connection = DBConnect.getConnection();
		        String query = "SELECT bids.productid, bids.bidamount, newproduct.sellerid, bids.status, newproduct.productname FROM bids INNER JOIN newproduct ON bids.productid = newproduct.productid WHERE bids.bidderid = ? AND newproduct.productname LIKE ? ";
		     
		        statement = connection.prepareStatement(query);
		        statement.setInt(1, id);
		        statement.setString(2, searchTerm+ "%");
		        ResultSet resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            Bid bid = new Bid();
		            bid.setProductname(resultSet.getString("productname"));
		            bid.setPid(resultSet.getInt("productid"));
		            bid.setSid(resultSet.getInt("sellerid"));
		            bid.setBidamount(resultSet.getInt("bidamount"));
		            bid.setStatus(resultSet.getString("status"));
		            searchResults.add(bid);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace(); 
		    } finally {
		    	try {
		    		connection.close();
		    		statement.close();
		    	}
		    	catch(SQLException e) {
		    		
		    	}
		    }

		    return searchResults;
		}
		
		
		
		
		// search products for the customers.
		public static List<Products> searchProductshome(String searchTerm) {
		    List<Products> searchResults = new ArrayList<Products>();

		    try {
		        connection = DBConnect.getConnection();
		        String query = "select productname, description, starting_bp,image from newproduct where productname LIKE ? ";
		     
		        statement = connection.prepareStatement(query);
		        statement.setString(1, searchTerm+ "%");
		        ResultSet resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		           Products p = new Products();
		           p.setProductname(resultSet.getString("productname"));
		           p.setProductdescription(resultSet.getString("description"));
		           p.setStarting_bp(resultSet.getString("starting_bp"));
		           p.setImage(resultSet.getString("image"));
		            searchResults.add(p);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace(); 
		    } finally {
		    	try {
		    		connection.close();
		    		statement.close();
		    	}
		    	catch(SQLException e) {
		    		
		    	}
		    }

		    return searchResults;
		}


		
	
		
		
		// find the total number of products for the sellers
		public static int TotalSellerProduct(int sellerid) {
			int count=0;
			
			String query="select count(*) from newproduct where sellerid=?";
			
			try {
				connection = DBConnect.getConnection();
				statement = connection.prepareStatement(query);
				
				statement.setLong(1, sellerid);
				
				ResultSet r = statement.executeQuery();
				
				while(r.next()) {
					count= r.getInt(1);
				}
			}
			catch(SQLException e) {
				
			}
			finally {
				try {
					if(connection !=null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
				}
				catch(SQLException w) {
					
				}
			}
			
			
			return count;
		}
		
		
		// find the total number of products alloted by the seller
		public static int TotalProductSellerAlloted(int sellerid) {
			int count=0;
			String query="select count(*) from bids inner JOIN newproduct on bids.productid = newproduct.productid where newproduct.sellerid= ? and bids.status = 'alloted'";
			
			try {
				connection = DBConnect.getConnection();
				statement = connection.prepareStatement(query);
				
				statement.setLong(1, sellerid);
				
				ResultSet r = statement.executeQuery();
				
				while(r.next()) {
					count= r.getInt(1);
				}
			}
			catch(SQLException e) {
				
			}
			finally {
				try {
					if(connection !=null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
				}
				catch(SQLException w) {
					
				}
			}
			
			return count;
		}
		
		//find the total number of products in pending state for seller
		public static int TotalSellerProductsPending(int sellerid) {
			int count= 0;
			String query="select count(*) from bids inner JOIN newproduct on bids.productid = newproduct.productid where newproduct.sellerid= ? and bids.status = 'pending'";
			
			try {
				connection = DBConnect.getConnection();
				statement = connection.prepareStatement(query);
				
				statement.setLong(1, sellerid);
				
				ResultSet r = statement.executeQuery();
				
				while(r.next()) {
					count= r.getInt(1);
				}
			}
			catch(SQLException e) {
				
			}
			finally {
				try {
					if(connection !=null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
				}
				catch(SQLException w) {
					
				}
			}
			
			return count;
		}
		
		
		// find the highest bid done for the seller product
		public static long HighestProductBId(int sellerid) {
			long bid=0;
            String query="select bids.bidamount from bids inner JOIN newproduct on bids.productid = newproduct.productid where newproduct.sellerid = ? ORDER BY bids.bidamount DESC LIMIT 1";
			
			try {
				connection = DBConnect.getConnection();
				statement = connection.prepareStatement(query);
				
				statement.setLong(1, sellerid);
				
				ResultSet r = statement.executeQuery();
				
				while(r.next()) {
					bid= r.getLong(1);
				}
			}
			catch(SQLException e) {
				
			}
			finally {
				try {
					if(connection !=null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
				}
				catch(SQLException w) {
					
				}
			}
			
			return bid;
		}
		
		
		
		// store the message 
		
		public static boolean SendMessage(String id, String name, String message) {
			
			String query ="insert into messaging( id , name , message) values( ?, ?, ? )";
			try {
				connection = DBConnect.getConnection();
				statement = connection.prepareStatement(query);
				
				statement.setInt(1, Integer.parseInt(id));
				statement.setString(2, name);
				statement.setString(3, message);

				int r = statement.executeUpdate();
				
			if( r > 0)
				return true;
			
			else
			{
				return false;
			}
			}
			catch(SQLException e) {
				return false;
			}
			finally {
				try {
					if(connection !=null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
				}
				catch(SQLException w) {
					
				}
			}
		}
		
		
		// fetch message data
		public static List<List<String>> FetchMessages(){
			List<List<String>> str = new ArrayList<List<String>>();
			String query = "select * from messaging";
			
			try {
				connection = DBConnect.getConnection();
				statement = connection.prepareStatement(query);
				
				ResultSet  r = statement.executeQuery();
				
				while(r.next()) {
					List<String> s = new ArrayList<>();
					s.add(String.valueOf(r.getInt("sn")));
					s.add(String.valueOf(r.getInt("id")));
					s.add(r.getString("name"));
					s.add(r.getString("email"));
					
					str.add(s);

				}
			}
			catch(SQLException e) {
				
			}
			finally {
				try {
					if(connection !=null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
				}
				catch(SQLException w) {
					
				}
			}
			
			return str;
		}
		
		
		// subscribe users
		public static void Subsrcibe(String email) {
			
			String query = "insert into Subscription(email) values( ? )";
			
			try {
				connection = DBConnect.getConnection();
				statement = connection.prepareStatement(query);
				
				statement.setString(1, email);
				
				
				statement.executeUpdate();
				
				
			}
			catch(SQLException e) {
				
			}
			finally {
				try {
					if(connection !=null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
				}
				catch(SQLException w) {
					
				}
			}
	
			
		}
		
		
		
		public static void BIds(int id,int bidderid,long bidamount) {
			Connection connection= null;
			PreparedStatement preparedStatement = null;
			
		    try {
		    	connection = DBConnect.getConnection();
		    	
		    	if( findid(id)==false && "pending".equals(status(id))==false) {
		    	    String	sqlString= "insert into bids(productid,bidderid,bidamount,status)values(?,?,?,?)";
		    		preparedStatement = connection.prepareStatement(sqlString);
		        	preparedStatement.setInt(1, id);
		        	preparedStatement.setInt(2, bidderid);
		        	preparedStatement.setLong(3, bidamount);
		        	preparedStatement.setString(4, "pending");
		        	preparedStatement.executeUpdate();
		    	}
		    	else {
		    		if(amount(bidamount, id) == true  && "pending".equals(status(id))==true ) {
		    	    String sqlString="update bids set bidderid =?,bidamount=? where productid=?";
		    		preparedStatement = connection.prepareStatement(sqlString);
		        	preparedStatement.setInt(1, bidderid);
		        	preparedStatement.setLong(2, bidamount);
		        	preparedStatement.setInt(3, id);
		        	preparedStatement.executeUpdate();
				}
		    	}
		    	
		    	if( findid(id)==true && "pending".equals(status(id))==false) {
		    	    String	sqlString= "insert into bids(productid,bidderid,bidamount,status)values(?,?,?,?)";
		    		preparedStatement = connection.prepareStatement(sqlString);
		        	preparedStatement.setInt(1, id);
		        	preparedStatement.setInt(2, bidderid);
		        	preparedStatement.setLong(3, bidamount);
		        	preparedStatement.setString(4, "pending");
		        	preparedStatement.executeUpdate();
		    	}
				
			} catch (SQLException e) {
				// TODO: handle exception
			}finally {
				try {
					if(connection!= null) 
						connection.close();
					
					if(preparedStatement!=null)
						preparedStatement.close();
				}
				catch(SQLException e) {
					
				}
				
			}
		}
	 
		
		
}
