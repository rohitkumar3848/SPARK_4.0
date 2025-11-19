/*
 ===============================================================
                     JDBC MASTER NOTES + CODE
 ===============================================================

   This single program explains ALL JDBC concepts:

   1️⃣ What is JDBC?
      → Java API that lets Java communicate with any database.

   2️⃣ Steps to use JDBC
      STEP 1: Load Driver class
      STEP 2: Create Connection
      STEP 3: Create Statement / PreparedStatement
      STEP 4: Execute SQL (CRUD)
      STEP 5: Process ResultSet
      STEP 6: Close connection

   3️⃣ Driver loading
      Class.forName("com.mysql.cj.jdbc.Driver");

   4️⃣ Making DB Connection
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/mystd",
          "root",
          "root"
      );

   5️⃣ Statement vs PreparedStatement
      • Statement → normal SQL
      • PreparedStatement → parameterized SQL (safe, fast, no SQL injection)

   6️⃣ ResultSet Types
      - TYPE_FORWARD_ONLY (default)
      - TYPE_SCROLL_INSENSITIVE (cursor moves both ways, BUT not live)
      - TYPE_SCROLL_SENSITIVE (live result → reflects DB updates)

   7️⃣ Concurrency Modes
      - CONCUR_READ_ONLY
      - CONCUR_UPDATABLE

   8️⃣ Transactions
      con.setAutoCommit(false);
      con.commit();
      con.rollback();

   9️⃣ CRUD Operations
      INSERT, SELECT, UPDATE, DELETE

   🔟 Batch Processing
       stmt.addBatch(); stmt.executeBatch();

   ⭐ This complete program covers ALL.

=================================================================
*/

import java.sql.*;
        import java.util.HashMap;
import java.util.Map;

public class JDBC_All {

    public static void main(String[] args) {
        Connection con = null;

        try {

            /* --------------------------------------------------------
                       STEP 1 – LOAD THE DRIVER
               --------------------------------------------------------
               In JDBC 4+ this is optional but still used in interviews.
            */
            Class.forName("com.mysql.cj.jdbc.Driver");

            /* --------------------------------------------------------
                       STEP 2 – CREATE CONNECTION
               --------------------------------------------------------
               URL format = jdbc:mysql://host:port/database
            */
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd",
                    "root",
                    "Rohit@123"
            );

            /* ========================================================
                     CRUD USING NORMAL STATEMENT
               ======================================================== */

            System.out.println("\n========= USING NORMAL STATEMENT =========");

            Statement st = con.createStatement();

            /* ------------ INSERT USING STATEMENT -------------- */
            String insertQuery = "INSERT INTO student (id, stdName, age) VALUES (201,'Rohit',22)";
            int inserted = st.executeUpdate(insertQuery);
            System.out.println("Inserted rows: " + inserted);

            /* ------------ READ USING STATEMENT ---------------- */
            ResultSet rs1 = st.executeQuery("SELECT * FROM student");
            System.out.println("Reading data using Statement:");
            while (rs1.next()) {
                System.out.println(
                        rs1.getInt("id") + " | " +
                                rs1.getString("stdName") + " | " +
                                rs1.getInt("age")
                );
            }

            /* ------------ UPDATE USING STATEMENT -------------- */
            int updated = st.executeUpdate("UPDATE student SET age=30 WHERE id=201");
            System.out.println("Updated rows: " + updated);

            /* ------------ DELETE USING STATEMENT -------------- */
            int deleted = st.executeUpdate("DELETE FROM student WHERE id=201");
            System.out.println("Deleted rows: " + deleted);



            /* ========================================================
                     CRUD USING PREPARED STATEMENT
               ======================================================== */

            System.out.println("\n========= USING PREPARED STATEMENT =========");

            String insertPS = "INSERT INTO student (id,stdName,age) VALUES (?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(insertPS);

            pstmt.setInt(1, 301);
            pstmt.setString(2, "Ankit");
            pstmt.setInt(3, 21);
            pstmt.executeUpdate();

            pstmt.setInt(1, 302);
            pstmt.setString(2, "Rahul");
            pstmt.setInt(3, 25);
            pstmt.executeUpdate();

            System.out.println("Inserted multiple rows using PreparedStatement");



            /* ========================================================
                     RESULT SET TYPES
               ======================================================== */

            /* --------------------------------------------------------
                1) TYPE_FORWARD_ONLY  (DEFAULT)
               -------------------------------------------------------- */
            System.out.println("\n===== ResultSet: TYPE_FORWARD_ONLY (default) =====");

            Statement stForward = con.createStatement(
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rsForward = stForward.executeQuery("SELECT * FROM student");

            while (rsForward.next()) {
                System.out.println("FO: " + rsForward.getInt("id") + " | " + rsForward.getString("stdName"));
            }



            /* --------------------------------------------------------
                2) TYPE_SCROLL_INSENSITIVE
                   → cursor can move anywhere
                   → DOES NOT reflect DB changes
               -------------------------------------------------------- */
            System.out.println("\n===== ResultSet: TYPE_SCROLL_INSENSITIVE =====");

            Statement stInsensitive = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rsIns = stInsensitive.executeQuery("SELECT * FROM student");

            rsIns.last();
            System.out.println("Last row ID: " + rsIns.getInt("id"));

            rsIns.first();
            System.out.println("First row Name: " + rsIns.getString("stdName"));

            rsIns.absolute(2);
            System.out.println("Row 2 Name: " + rsIns.getString("stdName"));



            /* --------------------------------------------------------
                3) TYPE_SCROLL_SENSITIVE
                   → LIVE RESULT SET
                   → reflects DB updates made externally
               -------------------------------------------------------- */
            System.out.println("\n===== ResultSet: TYPE_SCROLL_SENSITIVE =====");

            Statement stSensitive = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rsSen = stSensitive.executeQuery("SELECT * FROM student");

            Map<Integer, Integer> original = new HashMap<>();

            while (rsSen.next()) {
                original.put(rsSen.getInt("id"), rsSen.getInt("age"));
            }

            System.out.println("Original Data: " + original);

            System.out.println("Waiting 15 sec… Update database manually...");
            Thread.sleep(15000); // now update in MySQL manually

            rsSen.beforeFirst();
            System.out.println("Updated Data from DB (LIVE):");
            while (rsSen.next()) {
                System.out.println(rsSen.getInt("id") + " | " +
                        rsSen.getString("stdName") + " | " +
                        rsSen.getInt("age"));
            }



            /* ========================================================
                     TRANSACTION MANAGEMENT
               ======================================================== */

            System.out.println("\n========= TRANSACTION DEMO =========");

            con.setAutoCommit(false);   // disable auto commit

            PreparedStatement pstmtTrans =
                    con.prepareStatement("UPDATE student SET age = age + 1 WHERE id=?");

            pstmtTrans.setInt(1, 301);
            pstmtTrans.executeUpdate();

            System.out.println("Transaction executed but NOT committed…");

            // con.rollback();   // uncomment to test rollback
            con.commit();        // finalize changes

            System.out.println("Transaction committed!");



        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("\n========= PROGRAM ENDED =========");
        }
    }
}
