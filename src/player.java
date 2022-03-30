//TODO: add all remaining functions necessary for player movement and combat. Specifically, how to implement mouse + WASD movement, dashing, an inventory feature/management, and collision detection.
public class player {
    public String name;
    public int speed;
    public int health;
    public int cHealth;
    public int armor;
    public int ammo;
    public int slope;
    public int eqConst;
    public int oldX;
    public int oldY;
    public int Y;
    public int X;
    //wtf does this even do lmao i can sense this backfiring
    public player(String name, int speed, int health, int ammo, int armor, int X, int Y){
        this.name = name;
        this.speed = speed;
        this.health = health;
        this.cHealth = health;
        this.ammo = ammo;
        this.armor = armor;
        this.Y = Y;
        this.X = X;
        this.eqConst = Y;
        oldX = X;
        oldY = Y;
    }
    public String toString(){
        return("Player name: "+this.name+"\nHealth: "+this.cHealth+"/"+this.health+"\nSpeed: "+this.speed);
    }
    void CollisionDetect(int X, int Y){
        //trawl through the list of current entities, see if any are in collision range.
        //get the type of entity, then call the damage function, heal function, boost stats, or stop movement.
    }
    //y = mx+b. Hopefully the usage of this.X and this.Y instead of X and Y won't backfire *sweating*. This func should not be confused with the one for movement,
    // this one is to show enemies the current trajectory of the player so they can aim.
    void getLine(){
        slope = (this.Y-oldY)/(this.X-oldX);
        eqConst = this.Y-(slope*this.X);
        oldX = this.X;
        oldY = this.Y;
    }
   //this one is going to be hard. Good luck. This might be what you're looking for: https://processing.org/examples/constrain.html
    void linetoMouse(){

    }
    void movementHandle(){ //just going to call this function to handle WASD input.

    }
    void takeDamage(int dmg){
        //if present, armor will absorb 1/2 the damage. For example, if we have 2 armor and take 3 damage, we will take 1/2 damage on 2 points of damage, and sustain the remaining damage in full, so we'll lose 2 health.
        if(this.armor > 0){
            if(this.armor >=dmg){
                this.armor-=dmg;
                this.health-=(dmg/2);
            }
            else{
                int absorb = this.armor/2;
                int fd = dmg-this.armor;
                this.armor = 0;
                this.health-=absorb;
                this.health-=fd;

            }
        }
        else{
            this.health-=dmg;
        }
    }
    void heal(int healdmg){
        this.health+=healdmg;
    }
    void boostStats(int boostSpeed,int boostArmor, int boostAmmo){
        this.speed+=boostSpeed;
        this.armor+=boostArmor;
        this.ammo+=boostAmmo;
    }


}
