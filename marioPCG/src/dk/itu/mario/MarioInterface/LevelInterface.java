package dk.itu.mario.MarioInterface;

import java.util.ArrayList;

import dk.itu.mario.engine.sprites.SpriteTemplate;

public interface LevelInterface {
    
	public static ArrayList<byte[][]> population = new ArrayList<byte[][]>(0); //perhaps a heap
	
	
	public static byte[] TILE_BEHAVIORS = new byte[256];
    
    public static final int TYPE_OVERGROUND = 0;
    public static final int TYPE_UNDERGROUND = 1;
    public static final int TYPE_CASTLE = 2;

    public static final int BIT_BLOCK_UPPER = 1 << 0;
    public static final int BIT_BLOCK_ALL = 1 << 1;
    public static final int BIT_BLOCK_LOWER = 1 << 2;
    public static final int BIT_SPECIAL = 1 << 3; //mashroom or flower
    public static final int BIT_BUMPABLE = 1 << 4;
    public static final int BIT_BREAKABLE = 1 << 5;
    public static final int BIT_PICKUPABLE = 1 << 6;
    public static final int BIT_ANIMATED = 1 << 7;

    public void tick();
       
    /**DEPRECATED FOR getMember()
     *
     * @return
     */
    //Map of WIDTH * HEIGHT that contains the level's design 
    public byte[][] getMap();

    
    //Map of WIDTH * HEIGHT and contains the placement and type enemies
    public SpriteTemplate[][] getSpriteTemplates();

    public int getWidth();

    public int getHeight();
    
    //These are the place where the level ends
    public int getxExit();

    public int getyExit();
    
    public String getName();
    
    //Nick's additions
    
    /** USE INSTEAD OF getMap
     *  
     * @return a level map from the population generated by the GA
     */
    public byte[][] getMember(int mem);
    
    public float shannonPop(ArrayList<byte[][]> pop);
	public float shannonMember(byte[][] member);
	public float shannonSection( int beginRow, int endRow, int beginCol, int endCol);
	public void pop_tally(byte b);
	public void sec_tally(byte b);
	
	
	
	public ArrayList<byte[][]> section( int beginRow, int endRow, int beginCol, int endCol);

	public void mem_tally(byte b);
    

}