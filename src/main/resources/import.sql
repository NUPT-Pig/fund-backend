INSERT INTO fund_tb (fund_code, fund_name) VALUES ('501010', '汇添富中证生物科技主题指数（LOF）C');
INSERT INTO fund_tb (fund_code, fund_name) VALUES ('001618', '天弘中证电子指数C');
INSERT INTO fund_tb (fund_code, fund_name) VALUES ('001044', '嘉实新消费股票');
INSERT INTO fund_tb (fund_code, fund_name) VALUES ('160222', '国泰国证食品饮料行业');
INSERT INTO fund_tb (fund_code, fund_name) VALUES ('004070', '南方中证全指证券ETF联接C');

INSERT INTO stock_tb (stock_code, stock_name) VALUES ('000661', '长春高新');
INSERT INTO stock_tb (stock_code, stock_name) VALUES ('603259', '药明康德');
INSERT INTO stock_tb (stock_code, stock_name) VALUES ('300347', '泰格医药');

INSERT INTO stock_rating_tb (id, fund_code, stock_code, rate) VALUES (1, '501010', '000661', 9.72);
INSERT INTO stock_rating_tb (id, fund_code, stock_code, rate) VALUES (2, '501010', '603259', 8.98);
INSERT INTO stock_rating_tb (id, fund_code, stock_code, rate) VALUES (3, '501010', '300347', 5.2);