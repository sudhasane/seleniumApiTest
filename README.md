
Reading and writing data to excel

XLXSReader class include methods to
1:Read data from excel cell given column name
getCellDataWithColumnName(String sheetName, String colName, int rowNum)

2:Read data from excel cell given column number
getCellDataWithColumnNumber(String sheetName, int colNum, int rowNum)

3: writes data to an excel cell given columnName and rowNumber
setCellDataWithColumnName(String sheetName, String colName, int rowNum, String data)

4: writes data to an excel cell given columnNumber  and rowNumber
setCellDataWithColumnNumber(String sheetName, int colNum, int rowNum, String data) 

5:Return column number given column name
getColumnNumber(String sheetName, String colName)

Input excel  is under src/test/resources/testData

Request pay load is under  src/test/resources/requestPayload/DomainsJourneyMockData.xlsx
channelWebRequest.json  contains request body where customerId is the query parameter
respone.json  is the sample response  where ContainerName, actionId, action , issue, 
issue, channel and  name to be validated and InteractionID should be saved to a variable which would be used as request param in another request.




