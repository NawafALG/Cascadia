public class PrintBoard {
    int rows = 8;
    int cols = 8;
    Tile[] obj;
    PrintBoard(){
        obj = new Tile[rows*cols];
        for (int i = 0; i < obj.length; i++) {
            obj[i] = new Tile();
        }
    }

    public void init(){

        for(int i =0;i<rows;i++){
            String output = "";

            if (i%2==0) output = output.concat("      ");
            for(int j=0;j<cols;j++)
                output = output.concat(obj[j].row1());

            System.out.println(output);
            output = "";
            if (i%2==0) output = output.concat("      ");
            for(int j=0;j<cols;j++)
                output = output.concat(obj[j].row2());

            System.out.println(output);
            output = "";
            if (i%2==0) output = output.concat("      ");
            for(int j=0;j<cols;j++)
                output = output.concat(obj[j].row3());

            System.out.println(output);
            output = "";
            if (i%2==0) output = output.concat("      ");
            for(int j=0;j<cols;j++)
                output = output.concat(obj[j].row4());

            System.out.println(output);
        }

//        obj[1].print("1,2");
    }

}
