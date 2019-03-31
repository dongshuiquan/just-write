import org.junit.Test;

import java.sql.*;

/**
 * Created by DELL on 2018/8/13.
 */
public class Test01 {

    @Test
    public void test01() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mapper?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true",
                "root", "root");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select 1 from t_user");
        System.out.println(resultSet.next());
    }

    @Test
    public void getTableInfo() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:dong", "infodba", "infodba");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select 2 *3 from dual");
        if(resultSet.next()) {
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);

        }
        DatabaseMetaData metaData = connection.getMetaData();
        String[] types = { "TABLE" };
        ResultSet rs = metaData.getTables(null, null, "%", types);
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");  //表名
            String tableType = rs.getString("TABLE_TYPE");  //表类型
            String remarks = rs.getString("REMARKS");       //表备注
            System.out.println(tableName + " - " + tableType + " - " + remarks);
        }

        connection.close();
    }


    @Test
    public  void getColumnsInfo() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:dong", "infodba", "infodba");
        ResultSet rs = null;

        try{
            /**
             * 设置连接属性,使得可获取到列的REMARK(备注)
             */
            //((OracleConnection)conn).setRemarksReporting(true);
            DatabaseMetaData dbmd = conn.getMetaData();
            /**
             * 获取可在指定类别中使用的表列的描述。
             * 方法原型:ResultSet getColumns(String catalog,String schemaPattern,String tableNamePattern,String columnNamePattern)
             * catalog - 表所在的类别名称;""表示获取没有类别的列,null表示获取所有类别的列。
             * schema - 表所在的模式名称(oracle中对应于Tablespace);""表示获取没有模式的列,null标识获取所有模式的列; 可包含单字符通配符("_"),或多字符通配符("%");
             * tableNamePattern - 表名称;可包含单字符通配符("_"),或多字符通配符("%");
             * columnNamePattern - 列名称; ""表示获取列名为""的列(当然获取不到);null表示获取所有的列;可包含单字符通配符("_"),或多字符通配符("%");
             */
            rs =dbmd.getColumns(null, null, "EMP", null);

            while(rs.next()){
                String tableCat = rs.getString("TABLE_CAT");  //表类别（可能为空）
                String tableSchemaName = rs.getString("TABLE_SCHEM");  //表模式（可能为空）,在oracle中获取的是命名空间,其它数据库未知
                String tableName_ = rs.getString("TABLE_NAME");  //表名
                String columnName = rs.getString("COLUMN_NAME");  //列名
                int dataType = rs.getInt("DATA_TYPE");     //对应的java.sql.Types的SQL类型(列类型ID)
                String dataTypeName = rs.getString("TYPE_NAME");  //java.sql.Types类型名称(列类型名称)
                int columnSize = rs.getInt("COLUMN_SIZE");  //列大小
                int decimalDigits = rs.getInt("DECIMAL_DIGITS");  //小数位数
                int numPrecRadix = rs.getInt("NUM_PREC_RADIX");  //基数（通常是10或2） --未知
                /**
                 *  0 (columnNoNulls) - 该列不允许为空
                 *  1 (columnNullable) - 该列允许为空
                 *  2 (columnNullableUnknown) - 不确定该列是否为空
                 */
                int nullAble = rs.getInt("NULLABLE");  //是否允许为null
                String remarks = rs.getString("REMARKS");  //列描述
                String columnDef = rs.getString("COLUMN_DEF");  //默认值
                int charOctetLength = rs.getInt("CHAR_OCTET_LENGTH");    // 对于 char 类型，该长度是列中的最大字节数
                int ordinalPosition = rs.getInt("ORDINAL_POSITION");   //表中列的索引（从1开始）
                /**
                 * ISO规则用来确定某一列的是否可为空(等同于NULLABLE的值:[ 0:'YES'; 1:'NO'; 2:''; ])
                 * YES -- 该列可以有空值;
                 * NO -- 该列不能为空;
                 * 空字符串--- 不知道该列是否可为空
                 */
                String isNullAble = rs.getString("IS_NULLABLE");

                /**
                 * 指示此列是否是自动递增
                 * YES -- 该列是自动递增的
                 * NO -- 该列不是自动递增
                 * 空字串--- 不能确定该列是否自动递增
                 */
                //String isAutoincrement = rs.getString("IS_AUTOINCREMENT");   //该参数测试报错


                System.out.println(tableCat + " - " + tableSchemaName + " - " + tableName_ + " - " + columnName +
                        " - " + dataType + " - " + dataTypeName + " - " + columnSize + " - " + decimalDigits + " - "
                        + numPrecRadix + " - " + nullAble + " - " + remarks + " - " + columnDef + " - " + charOctetLength
                        + " - " + ordinalPosition + " - " + isNullAble );

            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            conn.close();
        }
    }



}
