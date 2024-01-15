-- using the database bidding_system
use bidding_system;



-- creating a user table.
create table users(userId bigint not null, userName varchar(20) not null,FullName varchar(40) not null , userEmail varchar(40) not null, userPhoneNumber bigint not null, userAddress varchar(60) not null
, userImg varchar(60), password varchar(40) not null, primary key(userId));



-- creating a seller table.
create table seller(sellerId bigint not null, sellerName varchar(20) not null,FullName varchar(40) not null , sellerEmail varchar(40) not null, sellerPhoneNumber bigint not null, sellerAddress varchar(60) not null
, sellerImg varchar(60), sellerpassword varchar(40) not null, primary key(sellerId));



-- creating a product table
create table product( productId bigint not null primary key, productName varchar(50) not null, productDescription varchar(90) not null, ProductAmount bigint not null, productSellerId bigint not null,
productImg varchar(50) not null, foreign key(productSellerId) references seller(sellerId) on delete cascade);


-- creating a BId table
create table Bid(BidId bigint not null primary key, BidDay date not null, BidstartTime Time not null, BidEndTime Time not null, BidProductId bigint not null, foreign key(BidProductId) references product(productId) on delete cascade);


-- create a table  containing the bids
create table ProductBid(todayBids bigint not null primary key , productBidId bigint not null, userId bigint not null, BiddedAmount bigint not null,foreign key(productBidId) references Bid(BidId) on delete cascade,
    foreign key(userId) references users(userId) on delete cascade);